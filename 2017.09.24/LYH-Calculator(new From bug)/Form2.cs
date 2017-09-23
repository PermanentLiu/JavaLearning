using System;

namespace WindowsFormsApp5
{
    internal class Form2
    {
        internal void Show()
        {
            throw new NotImplementedException();
        }

        private float x1;
        private float x2;
        private string s1;
        private string s2;
        private string s;
        private int temp;
        private char operation;
        private float result;
        private Button more;
        private Button night_mode;
        private TextBox textBox1;
        private Button op_plus;
        private Button op_result;
        private Button op_minus;
        private Button op_multiply;
        private Button op_devide;
        private Button op_clear;
        private Button num9;
        private Button num8;
        private Button num7;
        private Button num6;
        private Button num4;
        private Button num5;
        private Button num3;
        private Button op_point;
        private Button num2;
        private Button num1;
        private Button num0;
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

        private void night_mode_Click(object sender, EventArgs e)
        {
            count++;

            if (count % 2 == 0)
            {
                this.BackColor = System.Drawing.Color.White;
            }
            else
            {
                this.BackColor = System.Drawing.Color.Black;
            }


        }

        private void more_Click(object sender, EventArgs e)
        {

        }

        private void InitializeComponent()
        {
            this.more = new System.Windows.Forms.Button();
            this.night_mode = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.op_plus = new System.Windows.Forms.Button();
            this.op_result = new System.Windows.Forms.Button();
            this.op_minus = new System.Windows.Forms.Button();
            this.op_multiply = new System.Windows.Forms.Button();
            this.op_devide = new System.Windows.Forms.Button();
            this.op_clear = new System.Windows.Forms.Button();
            this.num9 = new System.Windows.Forms.Button();
            this.num8 = new System.Windows.Forms.Button();
            this.num7 = new System.Windows.Forms.Button();
            this.num6 = new System.Windows.Forms.Button();
            this.num4 = new System.Windows.Forms.Button();
            this.num5 = new System.Windows.Forms.Button();
            this.num3 = new System.Windows.Forms.Button();
            this.op_point = new System.Windows.Forms.Button();
            this.num2 = new System.Windows.Forms.Button();
            this.num1 = new System.Windows.Forms.Button();
            this.num0 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // more
            // 
            this.more.Location = new System.Drawing.Point(1070, 496);
            this.more.Name = "more";
            this.more.Size = new System.Drawing.Size(171, 86);
            this.more.TabIndex = 39;
            this.more.Text = "more";
            this.more.UseVisualStyleBackColor = true;
            // 
            // night_mode
            // 
            this.night_mode.Location = new System.Drawing.Point(1078, 298);
            this.night_mode.Name = "night_mode";
            this.night_mode.Size = new System.Drawing.Size(164, 114);
            this.night_mode.TabIndex = 38;
            this.night_mode.Text = "night_mode";
            this.night_mode.UseVisualStyleBackColor = true;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(244, 236);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(733, 35);
            this.textBox1.TabIndex = 37;
            this.textBox1.Text = "  ";
            // 
            // op_plus
            // 
            this.op_plus.Location = new System.Drawing.Point(866, 418);
            this.op_plus.Name = "op_plus";
            this.op_plus.Size = new System.Drawing.Size(111, 149);
            this.op_plus.TabIndex = 36;
            this.op_plus.Text = "+";
            this.op_plus.UseVisualStyleBackColor = true;
            // 
            // op_result
            // 
            this.op_result.Location = new System.Drawing.Point(866, 608);
            this.op_result.Name = "op_result";
            this.op_result.Size = new System.Drawing.Size(111, 140);
            this.op_result.TabIndex = 35;
            this.op_result.Text = "=";
            this.op_result.UseVisualStyleBackColor = true;
            // 
            // op_minus
            // 
            this.op_minus.Location = new System.Drawing.Point(866, 324);
            this.op_minus.Name = "op_minus";
            this.op_minus.Size = new System.Drawing.Size(111, 50);
            this.op_minus.TabIndex = 34;
            this.op_minus.Text = "-";
            this.op_minus.UseVisualStyleBackColor = true;
            // 
            // op_multiply
            // 
            this.op_multiply.Location = new System.Drawing.Point(684, 324);
            this.op_multiply.Name = "op_multiply";
            this.op_multiply.Size = new System.Drawing.Size(111, 50);
            this.op_multiply.TabIndex = 33;
            this.op_multiply.Text = "*";
            this.op_multiply.UseVisualStyleBackColor = true;
            // 
            // op_devide
            // 
            this.op_devide.Location = new System.Drawing.Point(466, 324);
            this.op_devide.Name = "op_devide";
            this.op_devide.Size = new System.Drawing.Size(111, 50);
            this.op_devide.TabIndex = 32;
            this.op_devide.Text = "/";
            this.op_devide.UseVisualStyleBackColor = true;
            // 
            // op_clear
            // 
            this.op_clear.Location = new System.Drawing.Point(244, 324);
            this.op_clear.Name = "op_clear";
            this.op_clear.Size = new System.Drawing.Size(111, 50);
            this.op_clear.TabIndex = 31;
            this.op_clear.Text = "C";
            this.op_clear.UseVisualStyleBackColor = true;
            // 
            // num9
            // 
            this.num9.Location = new System.Drawing.Point(684, 418);
            this.num9.Name = "num9";
            this.num9.Size = new System.Drawing.Size(111, 50);
            this.num9.TabIndex = 30;
            this.num9.Text = "9";
            this.num9.UseVisualStyleBackColor = true;
            // 
            // num8
            // 
            this.num8.Location = new System.Drawing.Point(466, 418);
            this.num8.Name = "num8";
            this.num8.Size = new System.Drawing.Size(111, 50);
            this.num8.TabIndex = 29;
            this.num8.Text = "8";
            this.num8.UseVisualStyleBackColor = true;
            // 
            // num7
            // 
            this.num7.Location = new System.Drawing.Point(244, 418);
            this.num7.Name = "num7";
            this.num7.Size = new System.Drawing.Size(111, 50);
            this.num7.TabIndex = 28;
            this.num7.Text = "7";
            this.num7.UseVisualStyleBackColor = true;
            // 
            // num6
            // 
            this.num6.Location = new System.Drawing.Point(684, 517);
            this.num6.Name = "num6";
            this.num6.Size = new System.Drawing.Size(111, 50);
            this.num6.TabIndex = 27;
            this.num6.Text = "6";
            this.num6.UseVisualStyleBackColor = true;
            // 
            // num4
            // 
            this.num4.Location = new System.Drawing.Point(244, 517);
            this.num4.Name = "num4";
            this.num4.Size = new System.Drawing.Size(111, 50);
            this.num4.TabIndex = 26;
            this.num4.Text = "4";
            this.num4.UseVisualStyleBackColor = true;
            // 
            // num5
            // 
            this.num5.Location = new System.Drawing.Point(466, 517);
            this.num5.Name = "num5";
            this.num5.Size = new System.Drawing.Size(111, 50);
            this.num5.TabIndex = 25;
            this.num5.Text = "5";
            this.num5.UseVisualStyleBackColor = true;
            // 
            // num3
            // 
            this.num3.Location = new System.Drawing.Point(684, 608);
            this.num3.Name = "num3";
            this.num3.Size = new System.Drawing.Size(111, 50);
            this.num3.TabIndex = 24;
            this.num3.Text = "3";
            this.num3.UseVisualStyleBackColor = true;
            // 
            // op_point
            // 
            this.op_point.Location = new System.Drawing.Point(684, 698);
            this.op_point.Name = "op_point";
            this.op_point.Size = new System.Drawing.Size(111, 50);
            this.op_point.TabIndex = 23;
            this.op_point.Text = ".";
            this.op_point.UseVisualStyleBackColor = true;
            // 
            // num2
            // 
            this.num2.Location = new System.Drawing.Point(466, 608);
            this.num2.Name = "num2";
            this.num2.Size = new System.Drawing.Size(111, 50);
            this.num2.TabIndex = 22;
            this.num2.Text = "2";
            this.num2.UseVisualStyleBackColor = true;
            // 
            // num1
            // 
            this.num1.Location = new System.Drawing.Point(244, 608);
            this.num1.Name = "num1";
            this.num1.Size = new System.Drawing.Size(111, 50);
            this.num1.TabIndex = 21;
            this.num1.Text = "1";
            this.num1.UseVisualStyleBackColor = true;
            // 
            // num0
            // 
            this.num0.Location = new System.Drawing.Point(244, 698);
            this.num0.Name = "num0";
            this.num0.Size = new System.Drawing.Size(333, 50);
            this.num0.TabIndex = 20;
            this.num0.Text = "0";
            this.num0.UseVisualStyleBackColor = true;
            // 
            // From2
            // 
            this.ClientSize = new System.Drawing.Size(1486, 985);
            this.Controls.Add(this.more);
            this.Controls.Add(this.night_mode);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.op_plus);
            this.Controls.Add(this.op_result);
            this.Controls.Add(this.op_minus);
            this.Controls.Add(this.op_multiply);
            this.Controls.Add(this.op_devide);
            this.Controls.Add(this.op_clear);
            this.Controls.Add(this.num9);
            this.Controls.Add(this.num8);
            this.Controls.Add(this.num7);
            this.Controls.Add(this.num6);
            this.Controls.Add(this.num4);
            this.Controls.Add(this.num5);
            this.Controls.Add(this.num3);
            this.Controls.Add(this.op_point);
            this.Controls.Add(this.num2);
            this.Controls.Add(this.num1);
            this.Controls.Add(this.num0);
            this.Name = "From2";
            this.ResumeLayout(false);
            this.PerformLayout();

        }
    }
    }
}