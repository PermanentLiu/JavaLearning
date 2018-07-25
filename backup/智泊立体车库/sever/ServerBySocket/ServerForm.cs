using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySQLDriverCS;
using WindowsFormsApplication1;
using System.Timers;

namespace ServerBySocket
{
    public partial class ServerForm : Form
    {
        SocketManager _sm = null;
        string ip = "192.168.1.101";
        int port = 26900;
        public static string cardID;
        public static string money;
        public static string Old_Cip;
        public MySQLConnection mq;
        public static DateTime dtime;
        public static string guan;
        public static string yong;
        public static string park;
        public static string guard;
        public static string car_num;
        public static string use_name;
        public static string parknum;
        public static string use_ID;
        System.Timers.Timer ti = new System.Timers.Timer();

        public ServerForm()
        {
            InitializeComponent();
            mq = new MySQLConnection(new MySQLConnectionString("localhost", "mysql", "root", "123").AsString);
            mq.Open();    
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            _sm = new SocketManager(ip, port);
            _sm.OnReceiveMsg += OnReceiveMsg;
            _sm.OnConnected += OnConnected;
            _sm.OnDisConnected += OnDisConnected;
            _sm.Start();
            init();
            ti.Interval = 60000;//60s定时器
            ti.Elapsed += new System.Timers.ElapsedEventHandler(theout);//到达时间的时候执行事件；
            ti.AutoReset = false;//设置是执行一次（false）还是一直执行(true)；
            ti.Enabled = true;//是否执行System.Timers.Timer.Elapsed事件；
            ti.Stop();
        }

        public void theout(object source, System.Timers.ElapsedEventArgs e)
        {
            _sm.SendMsg("time-out!", yong);
            MySQLCommand comm = new MySQLCommand("UPDATE car_flag SET ID_card = null,flag='0',car_phone=null WHERE ID ='" + cardID + "'", mq);
            comm.ExecuteNonQuery();
        }

        void init()
        {
            txtMsg.Text += GetDateNow() +"  服务器启动成功！\r\n";
            lblIp.Text = ip;
            lblPort.Text = port.ToString();
            lblStatus.Text = "正常启动";
        }

        public void OnReceiveMsg(string ip)
        {
            byte[] buffer = _sm._listSocketInfo[ip].msgBuffer;
            string msg = Encoding.ASCII.GetString(buffer).Replace("\0", "");
            if (txtMsg.InvokeRequired)
            {
                this.Invoke(new Action(() =>
                {
                    txtMsg.Text += AppendReceiveMsg(msg, ip);                   
                }));

            }
            else
            {
                txtMsg.Text += AppendReceiveMsg(msg, ip);
            }
            Receivesredus(msg, ip);
        }

        public void OnConnected(string clientIP)
        {
            string ipstr = clientIP.Split(':')[0];
            string portstr = clientIP.Split(':')[1];
            if (txtMsg.InvokeRequired)
            {
                this.Invoke(new Action(() => {
                    txtMsg.Text += clientIP + "已连接至本机\r\n";
                    object obj = new { Value = clientIP, Text = clientIP };
                    cbClient.Items.Add(obj);
                    cbClient.DisplayMember = "Value";
                    cbClient.ValueMember = "Text";
                    cbClient.SelectedItem = obj;
                }));
            }
            else
            {
                txtMsg.Text += clientIP + "已连接至本机\r\n";
            }
        }

        public void OnDisConnected(string clientIp)
        {
            if (txtMsg.InvokeRequired)
            {
                this.Invoke(new Action(() =>
                {
                    txtMsg.Text += clientIp + "已经断开连接！\r\n";
                    object obj = new { Value = clientIp, Text = clientIp };
                    cbClient.Items.Remove(obj);
                }));
            }
            else
            {
                txtMsg.Text += clientIp + "已经断开连接！\r\n";
            }
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            if (!_sm._listSocketInfo.Keys.Contains(cbClient.Text)) return;
            _sm.SendMsg(txtSend.Text, cbClient.Text);
            txtMsg.Text += AppendSendMsg(txtSend.Text, cbClient.Text);
            txtSend.Text = "";
        }

        public string AppendSendMsg(string msg, string ipClient)
        {
            return GetDateNow() + "  " + "[发送" + ipClient + "]  " + msg + "\r\n\r\n";
        }

        public string AppendReceiveMsg(string msg, string ipClient)
        {
            return GetDateNow() + "  " + "[接收" + ipClient + "]  " + msg + "\r\n\r\n";
        }

        public void ipget(string msg, string ipClient)
        {
            if (msg.IndexOf("android") != -1)
            {
                yong = ipClient;
            }
            else if (msg.IndexOf("stm32") != -1)
            {
                guan = ipClient;
            }
            else if(msg.IndexOf("park")!=-1)
            {
                park = ipClient;    
            }
            else if (msg.IndexOf("guard") != -1)
            {
                guard = ipClient;
            }
            else if(Old_Cip!=ipClient)
                Old_Cip = ipClient;                
        }

        public void environment(string mag)
        {
            MySQLCommand comm;
            string time = "'" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss") + "'";
            string[] sArray = mag.Split(':');
            if (textBox1.InvokeRequired)
            {
                this.Invoke(new Action(() =>
                textBox1.Text =  sArray[1]));

            }
            if (textBox2.InvokeRequired)
            {
                this.Invoke(new Action(() =>
                textBox2.Text =  sArray[2]));

            }
            if (textBox3.InvokeRequired)
            {
                this.Invoke(new Action(() =>
                textBox3.Text =sArray[3]));

            }
            string mydata =  time + ",'" + sArray[1] + "','" + sArray[2] + "','" + sArray[3] + "'";
            comm = new MySQLCommand("INSERT INTO environment(time,temp,humi,gas) VALUES(" + mydata + ")", mq);
            comm.ExecuteNonQuery();
        }

        public void Receivesredus(string msg, string ipClient)
        {
            ipget(msg, ipClient);
            TimeSpan ds = new TimeSpan();
            ds = DateTime.Now - dtime;                         
            int total = ds.Seconds;
            if ((total > 2) || (ipClient != guard))
            {
                if (ipClient==guard)
                dtime = DateTime.Now;
                if (msg.IndexOf("environment") != -1)
                {
                    environment(msg);
                }
                else if (msg.IndexOf("ID") != -1)
                {
                    string[] sArray = msg.Split(':');
                    if (txtcardID.InvokeRequired)
                    {
                        this.Invoke(new Action(() =>
                        txtcardID.Text = sArray[1]));

                    }
                }
                else if (msg.IndexOf("iD") != -1)
                {
                    string[] sArray = msg.Split(':');
                    if (txtcardID.InvokeRequired)
                    {
                        this.Invoke(new Action(() =>
                        txtcardID.Text = sArray[1]));

                    }
                    DateTime dt = DateTime.Now;
                    MySQLCommand comm = new MySQLCommand("SELECT * FROM `rfid_car` WHERE rfid_car.ID ='" + txtcardID.Text + "'", mq);
                    MySQLDataAdapter da = new MySQLDataAdapter();
                    comm.ExecuteNonQuery();
                    MySQLDataReader mqdata = comm.ExecuteReaderEx();
                    while (mqdata.Read())
                    {
                        if (mqdata.GetString(1) != null)
                        {
                            string ta = mqdata.GetString(4);
                            if (ta == "")
                            {
                                string time = "'" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss") + "'";
                                comm = new MySQLCommand("UPDATE rfid_car SET date = " + time + " WHERE ID = '" + txtcardID.Text + "'", mq); //更新停车信息
                                comm.ExecuteNonQuery();
                                if (txtcardID.Text == use_ID)
                                {
                                    comm = new MySQLCommand("UPDATE rfid_car SET car_num = " + use_name + " WHERE ID = '" + txtcardID.Text + "'", mq);
                                    comm.ExecuteNonQuery();
                                    ti.Stop();
                                    comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.car_phone ='" + use_name + "'", mq);
                                    comm.ExecuteNonQuery();
                                }
                                else
                                {
                                    comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.flag ='0'", mq);
                                    comm.ExecuteNonQuery();
                                    //                                    mqdata = comm.ExecuteReaderEx();
                                }
                                MySQLDataReader ba = comm.ExecuteReaderEx();
                                while (ba.Read())
                                {
                                    if (ba.GetString(1) != null)
                                    {
                                        parknum = ba.GetString(0);
                                        break;
                                    }
                                }
                                //                                car_num = null;
                                string dta = "8inttime:" + time + "carnum:" + car_num + "ID:" + txtcardID.Text;
                                _sm.SendMsg(dta, Old_Cip);

                                if (parknum != null)
                                {
                                    if (park != null)
                                    {
                                        int c = Convert.ToInt16(parknum) / 6;
                                        int d = Convert.ToInt16(parknum) % 6;
                                        string sendat = "jin" + c.ToString() + '.' + d.ToString();

                                        _sm.SendMsg(sendat, park);
                                    }
                                }
                                if (txtMsg.InvokeRequired)
                                {
                                    this.Invoke(new Action(() =>
                                    {
                                        txtMsg.Text += (dta + Old_Cip);
                                    }));

                                }
                                if (yong != null)
                                    _sm.SendMsg(dta, yong);
                                if (guan != null)
                                    _sm.SendMsg(dta, guan);
                                if (guard != null)
                                    _sm.SendMsg(dta, guard);
                            }
                            else
                            {
                                TimeSpan ts = new TimeSpan();
                                ts = DateTime.Now - Convert.ToDateTime(mqdata.GetString(4));//使用时间
                                string mo = Convert.ToString(ts.Seconds / 5);  //金额计算 时间/倍数
                                int money_cha = Convert.ToInt32(mqdata.GetString(3)) - Convert.ToInt32(mo);
                                if (money_cha > 0)
                                {
                                    string flag = "9usetime:" + ts.TotalSeconds.ToString() + "money" + Convert.ToString(money_cha) + "use_money" + mo + "in:" + mqdata.GetString(4) + "out:" + DateTime.Now.ToString() + "\r\n";
                                    comm = new MySQLCommand("UPDATE rfid_car SET date = NULL WHERE ID = '" + txtcardID.Text + "'", mq);   // 数据查找 更新停车信息
                                    comm.ExecuteNonQuery();
                                    comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.car_phone ='" + use_name + "'", mq);
                                    comm.ExecuteNonQuery();
                                    MySQLDataReader ba = comm.ExecuteReaderEx();
                                    while (ba.Read())
                                    {
                                        if (ba.GetString(1) != null)
                                        {
                                            parknum = ba.GetString(0);
                                            break;
                                        }
                                    }
                                    comm = new MySQLCommand("UPDATE car_flag SET ID_card = null,flag='0',car_phone=null WHERE ID_card ='" + txtcardID.Text + "'", mq);   // 数据查找 更新停车信息
                                    comm.ExecuteNonQuery();
                                    comm = new MySQLCommand("UPDATE rfid_car SET money = money-'" + mo + "'WHERE ID = '" + txtcardID.Text + "'", mq); // 扣费
                                    comm.ExecuteNonQuery();
                                    _sm.SendMsg(flag, Old_Cip);
                                    if (parknum != null)
                                    {
                                        if (park != null)
                                        {
                                            int c = Convert.ToInt16(parknum) / 6;
                                            int d = Convert.ToInt16(parknum) % 6;
                                            string sendat = "chu" + c.ToString() + '.' + d.ToString();

                                            _sm.SendMsg(sendat, park);
                                        }
                                    }
                                    if (txtMsg.InvokeRequired)
                                    {
                                        this.Invoke(new Action(() =>
                                        {
                                            txtMsg.Text += (flag + Old_Cip);
                                        }));

                                    }
                                    //else txtMsg.Text += (flag + Old_Cip);
                                    if (yong != null)
                                        _sm.SendMsg(flag, yong);
                                    if (guan != null)
                                        _sm.SendMsg(flag, guan);
                                }
                                else
                                {
                                    if (yong != null)
                                        _sm.SendMsg("not enuogh money", yong);
                                    if (guan != null)
                                        _sm.SendMsg("", guan);
                                }
                            }
                        }
                        else
                            _sm.SendMsg("user does not exist", Old_Cip);
                    }
                }
                else if (msg.IndexOf("environment") != -1)
                {
                    environment(msg);
                }
                //                else if (msg.IndexOf("phone") != -1)
                else if (ipClient == yong)
                {
                    string[] sArray = msg.Split(':');
                    if (msg.IndexOf("zc") != -1)
                    {
                        MySQLCommand comm;
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        string mydata = "'" + sArray[1] + "','" + sArray[2] + "','" + sArray[3] + "'";
                        comm = new MySQLCommand("INSERT INTO user_car(name,carnum,RFID) VALUES(" + mydata + ")", mq);
                        comm.ExecuteNonQuery();
                        _sm.SendMsg("success", Old_Cip);
                    }
                    else if (msg.IndexOf("dl") != -1)
                    {
                        string[] dl = msg.Split(':');
                        use_name = dl[1];
                        MySQLCommand comm = new MySQLCommand("SELECT * FROM `user_car` WHERE user_car.name ='" + sArray[1] + "'", mq);
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        comm.ExecuteNonQuery();
                        MySQLDataReader mqdata = comm.ExecuteReaderEx();
                        while (mqdata.Read())
                        {
                            //if (mqdata.GetString(1) != null)
                            //{
                            //    _sm.SendMsg("enable", Old_Cip);
                            //}
                            //else
                            //    _sm.SendMsg("error", Old_Cip);
                        }
                        /*                        int j = 0;
                        MySQLCommand comm = new MySQLCommand("SELECT * FROM `user_car` WHERE user_car.phone =" + sArray[1] + "", mq);
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        comm.ExecuteNonQuery();
                        MySQLDataReader mqdata = comm.ExecuteReaderEx();
                        while (mqdata.Read())
                        {
                            j = 1;
                                _sm.SendMsg("enable", Old_Cip);
                              
                        }                       
                        if(j==0)  _sm.SendMsg("error", Old_Cip);*/
                    }
                    else if (msg.IndexOf("order") != -1)
                    {
                        int t = 1;
//                        string name = sArray[1];
                        MySQLCommand comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.car_phone ='" + use_name + "'", mq);
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        comm.ExecuteNonQuery();
                        MySQLDataReader mqdata = comm.ExecuteReaderEx();
                        while (mqdata.Read())
                        {
                            if (mqdata.GetString(1) != null)
                            {
                                _sm.SendMsg("user car has been stored", Old_Cip);
                                t = 0;
                            }

                        }
                        if (t == 1)
                        {
                            int a = 0;
                            //                            string RFID;
                            comm = new MySQLCommand("SELECT * FROM `user_car` WHERE user_car.name ='" + use_name + "'", mq);
                            da = new MySQLDataAdapter();
                            comm.ExecuteNonQuery();
                            mqdata = comm.ExecuteReaderEx();
                            while (mqdata.Read())
                            {
                                if (mqdata.GetString(1) != null)
                                {
                                    use_ID = mqdata.GetString(2);
                                    break;
                                    //                                   a = 1;
                                }
                            }
                            comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.flag ='0'", mq);
                            da = new MySQLDataAdapter();
                            comm.ExecuteNonQuery();
                            MySQLDataReader ba = comm.ExecuteReaderEx();
                            while (ba.Read())
                            {
                                if (ba.GetString(1) != null)
                                {
                                    comm = new MySQLCommand(" UPDATE car_flag SET flag = '1',car_phone='" + use_name + "',ID_card='" + use_ID + "' WHERE ID ='" + ba.GetString(0) + "'", mq);
                                    comm.ExecuteNonQuery();
                                    string data = "job:" + use_name + ":" + ba.GetString(0);
    //                                use_name = sArray[2];
                                    if(guan!=null )
                                    _sm.SendMsg(data, guan);
                                    ti.Start();
                                    parknum =  ba.GetString(0);

                                    break;
                                }
                            }
                            //                          }
                        }
                    }
                    /*
                    else if (msg.IndexOf("car1") != -1)
                    {
                        MySQLCommand comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.car_phone ='" + sArray[2] + "'", mq);
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        comm.ExecuteNonQuery();
                        MySQLDataReader mqdata = comm.ExecuteReaderEx();
                        while (mqdata.Read())
                        {
                            if (mqdata.GetString(1) != null)
                            {
                                string data = "job:" + sArray[2] + ":" + mqdata.GetString(0);
                                _sm.SendMsg(data, guan);
                                _sm.SendMsg("please waiting", Old_Cip);
                                cardID = mqdata.GetString(0);
                            }
                            else
                            {
                                _sm.SendMsg("no car has been stored", Old_Cip);
                            }
                        } 
                    }*/
                    else if (msg.IndexOf("find") != -1)
                    {
                        int t = 1;
                        MySQLCommand comm = new MySQLCommand("SELECT * FROM `car_flag` WHERE car_flag.car_phone ='" + use_name + "'", mq);
                        MySQLDataAdapter da = new MySQLDataAdapter();
                        comm.ExecuteNonQuery();
                        MySQLDataReader mqdata = comm.ExecuteReaderEx();

                        string data = "data:"+textBox1.Text+":"+textBox2.Text+":"+textBox3.Text+":";
                        while (mqdata.Read())
                        {
                            if (mqdata.GetString(1) != null)
                            {
                                data += "park:" + mqdata.GetString(0) + "phone:" + mqdata.GetString(2) + "num:" + mqdata.GetString(3);
                                _sm.SendMsg(data, Old_Cip);
                                t = 0;
                            }

                        }
                        if (t == 1)
                        {
                            data += ":";
                        }
                            comm = new MySQLCommand("SELECT COUNT(ID) FROM car_flag WHERE flag='0'", mq);
                            da = new MySQLDataAdapter();
                            comm.ExecuteNonQuery();
                            mqdata = comm.ExecuteReaderEx();
                            while (mqdata.Read())
                            {
                                data += mqdata.GetString(0);
                               
                            }
                        _sm.SendMsg(data, Old_Cip);

                    }

                }
            }
        }

        public string GetDateNow()
        {
            return DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            _sm.Stop();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            cardID = txtcardID.Text;
            Form2 form = new Form2();
            form.ShowDialog();
        }

    }
}
