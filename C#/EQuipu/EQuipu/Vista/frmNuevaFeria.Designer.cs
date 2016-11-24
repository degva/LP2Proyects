namespace EQuipu.Vista
{
    partial class frmNuevaFeria
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.nombreBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.timeBoxPicker = new System.Windows.Forms.DateTimePicker();
            this.panel1 = new System.Windows.Forms.Panel();
            this.stand1 = new System.Windows.Forms.Panel();
            this.stand2 = new System.Windows.Forms.Panel();
            this.stand3 = new System.Windows.Forms.Panel();
            this.stand8 = new System.Windows.Forms.Panel();
            this.stand7 = new System.Windows.Forms.Panel();
            this.stand6 = new System.Windows.Forms.Panel();
            this.stand4 = new System.Windows.Forms.Panel();
            this.stand5 = new System.Windows.Forms.Panel();
            this.stand1Label = new System.Windows.Forms.Label();
            this.stand2Label = new System.Windows.Forms.Label();
            this.stand3Label = new System.Windows.Forms.Label();
            this.stand4Label = new System.Windows.Forms.Label();
            this.stand5Label = new System.Windows.Forms.Label();
            this.stand6Label = new System.Windows.Forms.Label();
            this.stand7Label = new System.Windows.Forms.Label();
            this.stand8Label = new System.Windows.Forms.Label();
            this.addBtn = new System.Windows.Forms.Button();
            this.cancelBtn = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.stand1.SuspendLayout();
            this.stand2.SuspendLayout();
            this.stand3.SuspendLayout();
            this.stand8.SuspendLayout();
            this.stand7.SuspendLayout();
            this.stand6.SuspendLayout();
            this.stand4.SuspendLayout();
            this.stand5.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Lugar:";
            // 
            // nombreBox
            // 
            this.nombreBox.Location = new System.Drawing.Point(80, 6);
            this.nombreBox.Name = "nombreBox";
            this.nombreBox.Size = new System.Drawing.Size(219, 20);
            this.nombreBox.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 39);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Fecha:";
            // 
            // timeBoxPicker
            // 
            this.timeBoxPicker.Location = new System.Drawing.Point(80, 33);
            this.timeBoxPicker.Name = "timeBoxPicker";
            this.timeBoxPicker.Size = new System.Drawing.Size(217, 20);
            this.timeBoxPicker.TabIndex = 3;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.panel1.Controls.Add(this.stand5);
            this.panel1.Controls.Add(this.stand4);
            this.panel1.Controls.Add(this.stand6);
            this.panel1.Controls.Add(this.stand7);
            this.panel1.Controls.Add(this.stand8);
            this.panel1.Controls.Add(this.stand3);
            this.panel1.Controls.Add(this.stand2);
            this.panel1.Controls.Add(this.stand1);
            this.panel1.Location = new System.Drawing.Point(12, 59);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(285, 348);
            this.panel1.TabIndex = 4;
            // 
            // stand1
            // 
            this.stand1.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand1.Controls.Add(this.stand1Label);
            this.stand1.Location = new System.Drawing.Point(4, 4);
            this.stand1.Name = "stand1";
            this.stand1.Size = new System.Drawing.Size(80, 80);
            this.stand1.TabIndex = 0;
            this.stand1.Tag = "1";
            this.stand1.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand2
            // 
            this.stand2.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand2.Controls.Add(this.stand2Label);
            this.stand2.Location = new System.Drawing.Point(4, 90);
            this.stand2.Name = "stand2";
            this.stand2.Size = new System.Drawing.Size(80, 80);
            this.stand2.TabIndex = 1;
            this.stand2.Tag = "2";
            this.stand2.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand3
            // 
            this.stand3.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand3.Controls.Add(this.stand3Label);
            this.stand3.Location = new System.Drawing.Point(4, 176);
            this.stand3.Name = "stand3";
            this.stand3.Size = new System.Drawing.Size(80, 80);
            this.stand3.TabIndex = 2;
            this.stand3.Tag = "3";
            this.stand3.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand8
            // 
            this.stand8.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand8.Controls.Add(this.stand8Label);
            this.stand8.Location = new System.Drawing.Point(198, 4);
            this.stand8.Name = "stand8";
            this.stand8.Size = new System.Drawing.Size(80, 80);
            this.stand8.TabIndex = 3;
            this.stand8.Tag = "8";
            this.stand8.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand7
            // 
            this.stand7.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand7.Controls.Add(this.stand7Label);
            this.stand7.Location = new System.Drawing.Point(198, 90);
            this.stand7.Name = "stand7";
            this.stand7.Size = new System.Drawing.Size(80, 80);
            this.stand7.TabIndex = 4;
            this.stand7.Tag = "7";
            this.stand7.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand6
            // 
            this.stand6.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand6.Controls.Add(this.stand6Label);
            this.stand6.Location = new System.Drawing.Point(198, 176);
            this.stand6.Name = "stand6";
            this.stand6.Size = new System.Drawing.Size(80, 80);
            this.stand6.TabIndex = 5;
            this.stand6.Tag = "6";
            this.stand6.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand4
            // 
            this.stand4.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand4.Controls.Add(this.stand4Label);
            this.stand4.Location = new System.Drawing.Point(59, 262);
            this.stand4.Name = "stand4";
            this.stand4.Size = new System.Drawing.Size(80, 80);
            this.stand4.TabIndex = 6;
            this.stand4.Tag = "4";
            this.stand4.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand5
            // 
            this.stand5.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.stand5.Controls.Add(this.stand5Label);
            this.stand5.Location = new System.Drawing.Point(145, 262);
            this.stand5.Name = "stand5";
            this.stand5.Size = new System.Drawing.Size(80, 80);
            this.stand5.TabIndex = 7;
            this.stand5.Tag = "5";
            this.stand5.Click += new System.EventHandler(this.asignarEquipo);
            // 
            // stand1Label
            // 
            this.stand1Label.AutoSize = true;
            this.stand1Label.Location = new System.Drawing.Point(4, 4);
            this.stand1Label.Name = "stand1Label";
            this.stand1Label.Size = new System.Drawing.Size(66, 13);
            this.stand1Label.TabIndex = 0;
            this.stand1Label.Text = "[Sin Asignar]";
            // 
            // stand2Label
            // 
            this.stand2Label.AutoSize = true;
            this.stand2Label.Location = new System.Drawing.Point(4, 4);
            this.stand2Label.Name = "stand2Label";
            this.stand2Label.Size = new System.Drawing.Size(27, 13);
            this.stand2Label.TabIndex = 0;
            this.stand2Label.Text = "[SA]";
            // 
            // stand3Label
            // 
            this.stand3Label.AutoSize = true;
            this.stand3Label.Location = new System.Drawing.Point(4, 4);
            this.stand3Label.Name = "stand3Label";
            this.stand3Label.Size = new System.Drawing.Size(27, 13);
            this.stand3Label.TabIndex = 0;
            this.stand3Label.Text = "[SA]";
            // 
            // stand4Label
            // 
            this.stand4Label.AutoSize = true;
            this.stand4Label.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.stand4Label.Location = new System.Drawing.Point(4, 4);
            this.stand4Label.Name = "stand4Label";
            this.stand4Label.Size = new System.Drawing.Size(21, 13);
            this.stand4Label.TabIndex = 0;
            this.stand4Label.Text = "SA";
            // 
            // stand5Label
            // 
            this.stand5Label.AutoSize = true;
            this.stand5Label.Location = new System.Drawing.Point(4, 4);
            this.stand5Label.Name = "stand5Label";
            this.stand5Label.Size = new System.Drawing.Size(21, 13);
            this.stand5Label.TabIndex = 0;
            this.stand5Label.Text = "SA";
            // 
            // stand6Label
            // 
            this.stand6Label.AutoSize = true;
            this.stand6Label.Location = new System.Drawing.Point(4, 4);
            this.stand6Label.Name = "stand6Label";
            this.stand6Label.Size = new System.Drawing.Size(21, 13);
            this.stand6Label.TabIndex = 0;
            this.stand6Label.Text = "SA";
            // 
            // stand7Label
            // 
            this.stand7Label.AutoSize = true;
            this.stand7Label.Location = new System.Drawing.Point(4, 4);
            this.stand7Label.Name = "stand7Label";
            this.stand7Label.Size = new System.Drawing.Size(21, 13);
            this.stand7Label.TabIndex = 0;
            this.stand7Label.Text = "SA";
            // 
            // stand8Label
            // 
            this.stand8Label.AutoSize = true;
            this.stand8Label.Location = new System.Drawing.Point(4, 4);
            this.stand8Label.Name = "stand8Label";
            this.stand8Label.Size = new System.Drawing.Size(21, 13);
            this.stand8Label.TabIndex = 0;
            this.stand8Label.Text = "SA";
            // 
            // addBtn
            // 
            this.addBtn.Location = new System.Drawing.Point(71, 413);
            this.addBtn.Name = "addBtn";
            this.addBtn.Size = new System.Drawing.Size(75, 23);
            this.addBtn.TabIndex = 5;
            this.addBtn.Text = "Agregar";
            this.addBtn.UseVisualStyleBackColor = true;
            this.addBtn.Click += new System.EventHandler(this.addBtn_Click);
            // 
            // cancelBtn
            // 
            this.cancelBtn.Location = new System.Drawing.Point(162, 413);
            this.cancelBtn.Name = "cancelBtn";
            this.cancelBtn.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.cancelBtn.Size = new System.Drawing.Size(75, 23);
            this.cancelBtn.TabIndex = 6;
            this.cancelBtn.Text = "Cancelar";
            this.cancelBtn.UseVisualStyleBackColor = true;
            this.cancelBtn.Click += new System.EventHandler(this.cancelBtn_Click);
            // 
            // frmNuevaFeria
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(311, 448);
            this.Controls.Add(this.cancelBtn);
            this.Controls.Add(this.addBtn);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.timeBoxPicker);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.nombreBox);
            this.Controls.Add(this.label1);
            this.Name = "frmNuevaFeria";
            this.Text = "Nueva Feria";
            this.panel1.ResumeLayout(false);
            this.stand1.ResumeLayout(false);
            this.stand1.PerformLayout();
            this.stand2.ResumeLayout(false);
            this.stand2.PerformLayout();
            this.stand3.ResumeLayout(false);
            this.stand3.PerformLayout();
            this.stand8.ResumeLayout(false);
            this.stand8.PerformLayout();
            this.stand7.ResumeLayout(false);
            this.stand7.PerformLayout();
            this.stand6.ResumeLayout(false);
            this.stand6.PerformLayout();
            this.stand4.ResumeLayout(false);
            this.stand4.PerformLayout();
            this.stand5.ResumeLayout(false);
            this.stand5.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox nombreBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DateTimePicker timeBoxPicker;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel stand1;
        private System.Windows.Forms.Panel stand5;
        private System.Windows.Forms.Panel stand4;
        private System.Windows.Forms.Panel stand6;
        private System.Windows.Forms.Panel stand7;
        private System.Windows.Forms.Panel stand8;
        private System.Windows.Forms.Panel stand3;
        private System.Windows.Forms.Panel stand2;
        private System.Windows.Forms.Label stand5Label;
        private System.Windows.Forms.Label stand4Label;
        private System.Windows.Forms.Label stand6Label;
        private System.Windows.Forms.Label stand7Label;
        private System.Windows.Forms.Label stand8Label;
        private System.Windows.Forms.Label stand3Label;
        private System.Windows.Forms.Label stand2Label;
        private System.Windows.Forms.Label stand1Label;
        private System.Windows.Forms.Button addBtn;
        private System.Windows.Forms.Button cancelBtn;
    }
}