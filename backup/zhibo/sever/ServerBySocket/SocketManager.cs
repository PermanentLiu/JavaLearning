using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ServerBySocket
{
    public class SocketManager
    {
        public Dictionary<string,SocketInfo> _listSocketInfo = null;
        Socket _socket = null;
        EndPoint _endPoint = null;
        bool _isListening = false;
        int BACKLOG = 10;

        public delegate void OnConnectedHandler(string clientIP);
        public event OnConnectedHandler OnConnected;
        public delegate void OnReceiveMsgHandler(string ip);
        public event OnReceiveMsgHandler OnReceiveMsg;
        public event OnReceiveMsgHandler OnDisConnected;

        public SocketManager(string ip, int port)
        {
            _socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            IPAddress _ip = IPAddress.Parse(ip);
            _endPoint = new IPEndPoint(_ip, port);
            _listSocketInfo = new Dictionary<string, SocketInfo>();
        }

        public void Start()
        {
            _socket.Bind(_endPoint); //绑定端口
            _socket.Listen(BACKLOG); //开启监听
            Thread acceptServer = new Thread(AcceptWork); //开启新线程处理监听
            acceptServer.IsBackground = true;
            _isListening = true;
            acceptServer.Start();
        }

        public void AcceptWork()
        {
            while (_isListening)
            {
                Socket acceptSocket = _socket.Accept();
                if (acceptSocket != null && this.OnConnected != null)
                {
                    SocketInfo sInfo = new SocketInfo();
                    sInfo.socket = acceptSocket;
                    _listSocketInfo.Add(acceptSocket.RemoteEndPoint.ToString(), sInfo);
                    OnConnected(acceptSocket.RemoteEndPoint.ToString());
                    Thread socketConnectedThread = new Thread(newSocketReceive);
                    socketConnectedThread.IsBackground = true;
                    socketConnectedThread.Start(acceptSocket);
                }
                Thread.Sleep(200);
            }
        }

        public void newSocketReceive(object obj)
        {
            Socket socket = obj as Socket;
            SocketInfo sInfo = _listSocketInfo[socket.RemoteEndPoint.ToString()];
            sInfo.isConnected = true;
            while (sInfo.isConnected)
            {
                try
                {
                    if (sInfo.socket == null) return;
                    //这里向系统投递一个接收信息的请求，并为其指定ReceiveCallBack做为回调函数 
                    sInfo.socket.BeginReceive(sInfo.buffer, 0, sInfo.buffer.Length, SocketFlags.None, ReceiveCallBack, sInfo.socket.RemoteEndPoint);
                }
                catch (Exception ex)
                {
                    return;
                }
                Thread.Sleep(100);
            }
        }

        private void ReceiveCallBack(IAsyncResult ar)
        {
            EndPoint ep = ar.AsyncState as IPEndPoint;
            SocketInfo info = _listSocketInfo[ep.ToString()];
            int readCount = 0;
            try
            {
                if (info.socket == null) return;
                readCount = info.socket.EndReceive(ar);
            }catch(Exception ex){
                return;
            }
            if (readCount > 0)
            {
                //byte[] buffer = new byte[readCount];
                //Buffer.BlockCopy(info.buffer, 0, buffer, 0, readCount);
                if (readCount < info.buffer.Length)
                {
                    byte[] newBuffer = new byte[readCount];
                    Buffer.BlockCopy(info.buffer, 0, newBuffer, 0, readCount);
                    info.msgBuffer = newBuffer;
                }
                else
                {
                    info.msgBuffer = info.buffer;
                }
                string msgTip = Encoding.ASCII.GetString(info.msgBuffer);
                if (msgTip == "\0\0\0faild")
                {
                    info.isConnected = false;
                    if (this.OnDisConnected != null) OnDisConnected(info.socket.RemoteEndPoint.ToString());
                    _listSocketInfo.Remove(info.socket.RemoteEndPoint.ToString());
                    info.socket.Close();
                    return;
                }
                if (OnReceiveMsg != null) OnReceiveMsg(info.socket.RemoteEndPoint.ToString());
            }
        }

        public void SendMsg(string text, string endPoint)
        {
            if (_listSocketInfo.Keys.Contains(endPoint) && _listSocketInfo[endPoint] != null)
            {
                _listSocketInfo[endPoint].socket.Send(Encoding.ASCII.GetBytes(text));
            }
        }

        public void Stop()
        {
            _isListening = false;
            foreach (SocketInfo s in _listSocketInfo.Values)
            {
                s.socket.Close();
            }
        }

        public class SocketInfo
        {
            public Socket socket = null;
            public byte[] buffer = null;
            public byte[] msgBuffer = null;
            public bool isConnected = false;

            public SocketInfo()
            {
                buffer = new byte[1024 * 4];
            }
        }
    }
}
