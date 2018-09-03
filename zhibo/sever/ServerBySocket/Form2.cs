using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
using MySQLDriverCS;
using ServerBySocket;

namespace WindowsFormsApplication1
{
    public partial class Form2 : Form
    {
        public static String txt1money;
        public MySQLConnection mq;
        public Form2()
        {
            InitializeComponent();
        }
        private void Form2_Load(object sender, EventArgs e)
        {
//            MySQLConnection mq;
            txtCID.Text = ServerForm.cardID;
            txtMoney.Text = ServerForm.money;
            mq = new MySQLConnection(new MySQLConnectionString("localhost", "mysql", "root", "123").AsString);
            mq.Open();           
        }

        private void button1_Click(object sender, EventArgs e)
        {
           
            MySQLCommand comm;
//            string time = "'" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss") + "'";
            MySQLDataAdapter da = new MySQLDataAdapter();
            //          comm = new MySQLCommand("UPDATE rfid_car(ID,user_name,car_num,money) SET date = " + time + " WHERE ID = " + txtCID.Text, mq);
//            string mydata = "'" + txtCID.Text + "','" + txtusername.Text + "','" + txtCarNum.Text + "','" + txtMoney.Text + "'";
            //          comm = new MySQLCommand("UPDATE rfid_car SET date = "+data+" WHERE ID = "+textBox1.Text, mq);
            comm = new MySQLCommand("update rfid_car set money=money+" + txtMoney.Text + " where ID='" + txtCID.Text + "'", mq);
            //            comm = new MySQLCommand("INSERT INTO rfid_car(ID,user_name,car_num,money) VALUES("+txtCID.Text+",111,123,123)", mq);
            comm.ExecuteNonQuery();
            MessageBox.Show("success "); 
            txt1money = txtCID.Text;
            this.Close();


        }

        private void button2_Click(object sender, EventArgs e)
        {

            MySQLCommand comm;
            string time ="'"+ DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")+"'";
            MySQLDataAdapter da = new MySQLDataAdapter();
//          comm = new MySQLCommand("UPDATE rfid_car(ID,user_name,car_num,money) SET date = " + time + " WHERE ID = " + txtCID.Text, mq);
            string mydata = "'" + txtCID.Text  + "','" + txtusername.Text + "','" + txtCarNum.Text + "','" + txtMoney.Text+"'";
//          comm = new MySQLCommand("UPDATE rfid_car SET date = "+data+" WHERE ID = "+textBox1.Text, mq);
            comm = new MySQLCommand("INSERT INTO rfid_car(ID,user_name,car_num,money) VALUES(" + mydata + ")", mq);
//            comm = new MySQLCommand("INSERT INTO rfid_car(ID,user_name,car_num,money) VALUES("+txtCID.Text+",111,123,123)", mq);
            comm.ExecuteNonQuery();
            MessageBox.Show("success "); 
            this.Close();
        }
        public string  UPDATA(string ID)
        {
            MySQLCommand comm;
            string aa=UPDATA_TIME(ID);
            string flag;
            if (aa == null)
            {
                string time = "'" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss") + "'";
                comm = new MySQLCommand("UPDATE rfid_car(ID,user_name,car_num,money) SET date = " + time + " WHERE ID = " + ID, mq);
                flag = "success";
            }
            else
            {
                TimeSpan ts = new TimeSpan();
                ts = DateTime.Now - Convert.ToDateTime(aa);
                flag = ts.TotalSeconds.ToString();                
            }
            return flag;
        }
        public string UPDATA_TIME(string ID)
        {
            string aa=null;
            MySQLCommand comm;
            comm = new MySQLCommand("SELECT * FROM `rfid_car` WHERE rfid_car.ID =" + ID, mq);//
            comm.ExecuteNonQuery();
            MySQLDataReader mqdata = comm.ExecuteReaderEx();
            try
            {
                while (mqdata.Read())
                {
                    aa = mqdata.GetString(4);
                }
            }
            finally
            {
                mqdata.Close();
                //                DBConn.Close();
            }
            return aa;
        }
        public void INSERT()
        {

        }
        public void SELECT(string ID)
        {
            DateTime dt = DateTime.Now;
            MySQLCommand comm;
            MySQLDataAdapter da = new MySQLDataAdapter();

            comm = new MySQLCommand("SELECT * FROM `rfid_car` WHERE rfid_car.ID =" + txtCID.Text, mq);
            comm.ExecuteNonQuery();
            MySQLDataReader mqdata = comm.ExecuteReaderEx();
            da.SelectCommand = comm;
            DataSet da_data = new DataSet();
            da.Fill(da_data);
            try
            {
                while (mqdata.Read())
                {
                    dataGridView1.DataSource = da_data.Tables[0].DefaultView;
                }
            }
            finally
            {
                mqdata.Close();
            }        
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            DateTime dt = DateTime.Now;
            MySQLCommand comm;
            MySQLDataAdapter da = new MySQLDataAdapter();
            comm = new MySQLCommand("SELECT * FROM `rfid_car` WHERE rfid_car.ID ='" + txtCID.Text + "'", mq);//
            comm.ExecuteNonQuery();
            MySQLDataReader mqdata = comm.ExecuteReaderEx();
            da.SelectCommand = comm;
            DataSet da_data = new DataSet();
            da.Fill(da_data);
            try
            {
                while (mqdata.Read())
                {
                    dataGridView1.DataSource = da_data.Tables[0].DefaultView;

                    //Form2 form = new Form2();
                    //form.ShowDialog();
                    //当前时间减数据库时间
                    //string aa = mqdata.GetString(4);
                    //TimeSpan ts = new TimeSpan();
                    //ts = DateTime.Now - Convert.ToDateTime(aa);
                    //textBox5.Text = ts.TotalSeconds.ToString(); 

                    //textBox1.Text = mqdata.GetString(0);
                    //textBox2.Text = mqdata.GetString(1);
                    //textBox3.Text = mqdata.GetString(2);
                    //txtMoney.Text = mqdata.GetString(3);
                    //textBox5.Text = mqdata.GetString(4);
                    //                    Console.WriteLine("Host = {0} and User = {1}", mqdata.GetString(0), mqdata.GetString(1));
                }
            }
            finally
            {
                mqdata.Close();
                //                DBConn.Close();
            }
            //关闭数据库连接
            //            DBConn.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            MySQLCommand comm;
            MySQLDataAdapter da = new MySQLDataAdapter();
            comm = new MySQLCommand("DELETE FROM rfid_car WHERE ID = '" + txtCID.Text + "'", mq);//
            comm.ExecuteNonQuery();
            MessageBox.Show("success "); 
            this.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            MySQLCommand comm;
            MySQLDataAdapter da = new MySQLDataAdapter();
            //            comm = new MySQLCommand("SELECT COUNT(ID) FROM car_flag WHERE flag='0'", mq);//
            comm = new MySQLCommand("SELECT * FROM `car_flag`", mq);
            comm.ExecuteNonQuery();
            MySQLDataReader mqdata = comm.ExecuteReaderEx();
            da.SelectCommand = comm;
            DataSet da_data = new DataSet();
            da.Fill(da_data);
            while (mqdata.Read())
            {
                dataGridView1.DataSource = da_data.Tables[0].DefaultView;
            }
        }
    }
}
