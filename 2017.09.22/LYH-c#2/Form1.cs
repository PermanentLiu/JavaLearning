using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random rad = new Random();
            this.label1.Left = this.label1.Left + 10;
            this.Text = DateTime.Now.ToString();
            this.label1.BackColor = Color.FromArgb(rad.Next(255), rad.Next(255), rad.Next(255));
        }
    }
}
