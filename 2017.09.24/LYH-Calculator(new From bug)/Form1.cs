using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApp5
{

    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private float x1;
        private float x2;
        private string s1;
        private string s2;
        private string s;
        private int temp;
        private char operation;
        private float result;
        private int count;



        private void num0_Click(object sender, EventArgs e)
        {
            addNum('0');
        }
        private void num1_Click(object sender, EventArgs e)
        {
            addNum('1');
        }
        private void num2_Click(object sender, EventArgs e)
        {
            addNum('2');
        }
        private void num3_Click(object sender, EventArgs e)
        {
            addNum('3');
        }
        private void num4_Click(object sender, EventArgs e)
        {
            addNum('4');
        }
        private void num5_Click(object sender, EventArgs e)
        {
            addNum('5');
        }
        private void num6_Click(object sender, EventArgs e)
        {
            addNum('6');
        }
        private void num7_Click(object sender, EventArgs e)
        {
            addNum('7');
        }
        private void num8_Click(object sender, EventArgs e)
        {
            addNum('8');
        }
        private void num9_Click(object sender, EventArgs e)
        {
            addNum('9');
        }
        private void op_point_Click(object sender, EventArgs e)
        {
            addNum('.');
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }





        private void addNum(char input)
        {
            textBox1.Text = textBox1.Text + input.ToString();
        }

        private void addNum(float input)
        {
            textBox1.Text = textBox1.Text + input.ToString();
        }


        private void calculate()
        {
            switch (operation)
            {
                case '+':
                    result = x1 + x2;
                    break;
                case '-':
                    result = x1 - x2;
                    break;
                case '*':
                    result = x1 * x2;
                    break;
                case '/':
                    result = x1 / x2;
                    break;
                default:
                    break;
            }
        }







        private void op_plus_Click(object sender, EventArgs e)
        {


            s1 = textBox1.Text;
            x1 = Convert.ToSingle(s1);
            temp = s1.Length;

            addNum('+');
            operation = '+';
            s = textBox1.Text;
        }
        private void op_minus_Click(object sender, EventArgs e)
        {
            s1 = textBox1.Text;
            x1 = Convert.ToSingle(s1);
            temp = s1.Length;

            addNum('-');
            operation = '-';
            s = textBox1.Text;
        }
        private void op_multiply_Click(object sender, EventArgs e)
        {
            s1 = textBox1.Text;
            x1 = Convert.ToSingle(s1);
            temp = s1.Length;

            addNum('*');
            operation = '*';
            s = textBox1.Text;
        }
        private void op_devide_Click(object sender, EventArgs e)
        {
            s1 = textBox1.Text;
            x1 = Convert.ToSingle(s1);
            temp = s1.Length;

            addNum('/');
            operation = '/';
            s = textBox1.Text;
        }

        private void op_result_Click(object sender, EventArgs e)
        {
            s = textBox1.Text;


            s2 = s.Remove(0, temp + 1);
            x2 = Convert.ToSingle(s2);

            addNum('=');

            calculate();
            addNum(result);

        }

        private void op_clear_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
        }

        

        private void more_Click(object sender, EventArgs e)
        {
            Form2 frm = new Form2();
            this.Hide();
            frm.Show();
            this.Show();
            
        }


    }
}
 