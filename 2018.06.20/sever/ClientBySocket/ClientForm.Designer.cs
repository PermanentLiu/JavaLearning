namespace ClientBySocket
{
    partial class ClientForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.txtMsg = new System.Windows.Forms.TextBox();
            this.lblClientIp = new System.Windows.Forms.Label();
            this.lblClientPort = new System.Windows.Forms.Label();
            this.lblRemoteIp = new System.Windows.Forms.Label();
            this.lblRemotePort = new System.Windows.Forms.Label();
            this.lblStatus = new System.Windows.Forms.Label();
            this.txtSend = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.lblClientIps = new System.Windows.Forms.Label();
            this.lblClientPorts = new System.Windows.Forms.Label();
            this.lblRemoteIps = new System.Windows.Forms.Label();
            this.lblRemotePorts = new System.Windows.Forms.Label();
            this.lblStatuss = new System.Windows.Forms.Label();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnConnected = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtMsg
            // 
            this.txtMsg.BackColor = System.Drawing.SystemColors.ControlLight;
            this.txtMsg.Location = new System.Drawing.Point(12, 14);
            this.txtMsg.Multiline = true;
            this.txtMsg.Name = "txtMsg";
            this.txtMsg.ReadOnly = true;
            this.txtMsg.Size = new System.Drawing.Size(468, 171);
            this.txtMsg.TabIndex = 0;
            // 
            // lblClientIp
            // 
            this.lblClientIp.AutoSize = true;
            this.lblClientIp.Location = new System.Drawing.Point(501, 17);
            this.lblClientIp.Name = "lblClientIp";
            this.lblClientIp.Size = new System.Drawing.Size(53, 12);
            this.lblClientIp.TabIndex = 1;
            this.lblClientIp.Text = "本机Ip：";
            // 
            // lblClientPort
            // 
            this.lblClientPort.AutoSize = true;
            this.lblClientPort.Location = new System.Drawing.Point(501, 50);
            this.lblClientPort.Name = "lblClientPort";
            this.lblClientPort.Size = new System.Drawing.Size(65, 12);
            this.lblClientPort.TabIndex = 2;
            this.lblClientPort.Text = "本机端口：";
            // 
            // lblRemoteIp
            // 
            this.lblRemoteIp.AutoSize = true;
            this.lblRemoteIp.Location = new System.Drawing.Point(501, 82);
            this.lblRemoteIp.Name = "lblRemoteIp";
            this.lblRemoteIp.Size = new System.Drawing.Size(53, 12);
            this.lblRemoteIp.TabIndex = 3;
            this.lblRemoteIp.Text = "远端Ip：";
            // 
            // lblRemotePort
            // 
            this.lblRemotePort.AutoSize = true;
            this.lblRemotePort.Location = new System.Drawing.Point(501, 111);
            this.lblRemotePort.Name = "lblRemotePort";
            this.lblRemotePort.Size = new System.Drawing.Size(65, 12);
            this.lblRemotePort.TabIndex = 4;
            this.lblRemotePort.Text = "远端端口：";
            // 
            // lblStatus
            // 
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(501, 140);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(41, 12);
            this.lblStatus.TabIndex = 5;
            this.lblStatus.Text = "状态：";
            // 
            // txtSend
            // 
            this.txtSend.Location = new System.Drawing.Point(12, 199);
            this.txtSend.Multiline = true;
            this.txtSend.Name = "txtSend";
            this.txtSend.Size = new System.Drawing.Size(468, 82);
            this.txtSend.TabIndex = 6;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(405, 292);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 7;
            this.button1.Text = "发送";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(12, 186);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(467, 12);
            this.label6.TabIndex = 8;
            this.label6.Text = "-----------------------------------------------------------------------------";
            // 
            // lblClientIps
            // 
            this.lblClientIps.AutoSize = true;
            this.lblClientIps.Location = new System.Drawing.Point(560, 17);
            this.lblClientIps.Name = "lblClientIps";
            this.lblClientIps.Size = new System.Drawing.Size(0, 12);
            this.lblClientIps.TabIndex = 9;
            // 
            // lblClientPorts
            // 
            this.lblClientPorts.AutoSize = true;
            this.lblClientPorts.Location = new System.Drawing.Point(561, 50);
            this.lblClientPorts.Name = "lblClientPorts";
            this.lblClientPorts.Size = new System.Drawing.Size(0, 12);
            this.lblClientPorts.TabIndex = 10;
            // 
            // lblRemoteIps
            // 
            this.lblRemoteIps.AutoSize = true;
            this.lblRemoteIps.Location = new System.Drawing.Point(560, 82);
            this.lblRemoteIps.Name = "lblRemoteIps";
            this.lblRemoteIps.Size = new System.Drawing.Size(0, 12);
            this.lblRemoteIps.TabIndex = 11;
            // 
            // lblRemotePorts
            // 
            this.lblRemotePorts.AutoSize = true;
            this.lblRemotePorts.Location = new System.Drawing.Point(560, 111);
            this.lblRemotePorts.Name = "lblRemotePorts";
            this.lblRemotePorts.Size = new System.Drawing.Size(0, 12);
            this.lblRemotePorts.TabIndex = 12;
            // 
            // lblStatuss
            // 
            this.lblStatuss.AutoSize = true;
            this.lblStatuss.Location = new System.Drawing.Point(561, 140);
            this.lblStatuss.Name = "lblStatuss";
            this.lblStatuss.Size = new System.Drawing.Size(0, 12);
            this.lblStatuss.TabIndex = 14;
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(503, 199);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(140, 23);
            this.btnClose.TabIndex = 15;
            this.btnClose.Text = "断开连接";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnConnected
            // 
            this.btnConnected.Location = new System.Drawing.Point(503, 258);
            this.btnConnected.Name = "btnConnected";
            this.btnConnected.Size = new System.Drawing.Size(140, 23);
            this.btnConnected.TabIndex = 16;
            this.btnConnected.Text = "重新连接";
            this.btnConnected.UseVisualStyleBackColor = true;
            this.btnConnected.Click += new System.EventHandler(this.btnConnected_Click);
            // 
            // ClientForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(655, 327);
            this.Controls.Add(this.btnConnected);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.lblStatuss);
            this.Controls.Add(this.lblRemotePorts);
            this.Controls.Add(this.lblRemoteIps);
            this.Controls.Add(this.lblClientPorts);
            this.Controls.Add(this.lblClientIps);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.txtSend);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.lblRemotePort);
            this.Controls.Add(this.lblRemoteIp);
            this.Controls.Add(this.lblClientPort);
            this.Controls.Add(this.lblClientIp);
            this.Controls.Add(this.txtMsg);
            this.Name = "ClientForm";
            this.Text = "ClientForm";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtMsg;
        private System.Windows.Forms.Label lblClientIp;
        private System.Windows.Forms.Label lblClientPort;
        private System.Windows.Forms.Label lblRemoteIp;
        private System.Windows.Forms.Label lblRemotePort;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.TextBox txtSend;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lblClientIps;
        private System.Windows.Forms.Label lblClientPorts;
        private System.Windows.Forms.Label lblRemoteIps;
        private System.Windows.Forms.Label lblRemotePorts;
        private System.Windows.Forms.Label lblStatuss;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnConnected;
    }
}

