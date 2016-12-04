namespace EQuipu.Vista
{
    partial class frmMantMiemEditor
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.boxTipo = new System.Windows.Forms.ComboBox();
            this.boxSexo = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.boxTimePicker = new System.Windows.Forms.DateTimePicker();
            this.boxEmail = new System.Windows.Forms.TextBox();
            this.boxDireccion = new System.Windows.Forms.TextBox();
            this.boxNombre = new System.Windows.Forms.TextBox();
            this.boxCodigo = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.boxCraest = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.boxCodigoPucp = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.boxEstado = new System.Windows.Forms.TextBox();
            this.label11 = new System.Windows.Forms.Label();
            this.boxCodigoProf = new System.Windows.Forms.TextBox();
            this.label10 = new System.Windows.Forms.Label();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.boxDedicacion = new System.Windows.Forms.ComboBox();
            this.label12 = new System.Windows.Forms.Label();
            this.btnGrabar = new System.Windows.Forms.Button();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.boxTipo);
            this.groupBox1.Controls.Add(this.boxSexo);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.boxTimePicker);
            this.groupBox1.Controls.Add(this.boxEmail);
            this.groupBox1.Controls.Add(this.boxDireccion);
            this.groupBox1.Controls.Add(this.boxNombre);
            this.groupBox1.Controls.Add(this.boxCodigo);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(25, 23);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(468, 174);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Datos Generales";
            // 
            // boxTipo
            // 
            this.boxTipo.FormattingEnabled = true;
            this.boxTipo.Items.AddRange(new object[] {
            "Alumno",
            "Profesor",
            "Externo"});
            this.boxTipo.Location = new System.Drawing.Point(323, 136);
            this.boxTipo.Name = "boxTipo";
            this.boxTipo.Size = new System.Drawing.Size(130, 21);
            this.boxTipo.TabIndex = 13;
            this.boxTipo.SelectedIndexChanged += new System.EventHandler(this.boxTipo_SelectedIndexChanged);
            // 
            // boxSexo
            // 
            this.boxSexo.FormattingEnabled = true;
            this.boxSexo.Items.AddRange(new object[] {
            "Masculino",
            "Femenino"});
            this.boxSexo.Location = new System.Drawing.Point(89, 136);
            this.boxSexo.Name = "boxSexo";
            this.boxSexo.Size = new System.Drawing.Size(121, 21);
            this.boxSexo.TabIndex = 12;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(251, 139);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(34, 13);
            this.label7.TabIndex = 11;
            this.label7.Text = "Tipo :";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(19, 139);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(37, 13);
            this.label6.TabIndex = 10;
            this.label6.Text = "Sexo :";
            // 
            // boxTimePicker
            // 
            this.boxTimePicker.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.boxTimePicker.Location = new System.Drawing.Point(323, 61);
            this.boxTimePicker.Name = "boxTimePicker";
            this.boxTimePicker.Size = new System.Drawing.Size(130, 20);
            this.boxTimePicker.TabIndex = 9;
            // 
            // boxEmail
            // 
            this.boxEmail.Location = new System.Drawing.Point(299, 98);
            this.boxEmail.Name = "boxEmail";
            this.boxEmail.Size = new System.Drawing.Size(155, 20);
            this.boxEmail.TabIndex = 8;
            // 
            // boxDireccion
            // 
            this.boxDireccion.Location = new System.Drawing.Point(89, 98);
            this.boxDireccion.Name = "boxDireccion";
            this.boxDireccion.Size = new System.Drawing.Size(155, 20);
            this.boxDireccion.TabIndex = 7;
            // 
            // boxNombre
            // 
            this.boxNombre.Location = new System.Drawing.Point(90, 61);
            this.boxNombre.Name = "boxNombre";
            this.boxNombre.Size = new System.Drawing.Size(155, 20);
            this.boxNombre.TabIndex = 6;
            // 
            // boxCodigo
            // 
            this.boxCodigo.Location = new System.Drawing.Point(90, 27);
            this.boxCodigo.Name = "boxCodigo";
            this.boxCodigo.Size = new System.Drawing.Size(100, 20);
            this.boxCodigo.TabIndex = 5;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(251, 101);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(42, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "E-Mail :";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(19, 101);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(58, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "Dirección :";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(251, 64);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(66, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Fecha Nac :";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(19, 64);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(50, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Nombre :";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(19, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(46, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Código :";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.boxCraest);
            this.groupBox2.Controls.Add(this.label9);
            this.groupBox2.Controls.Add(this.boxCodigoPucp);
            this.groupBox2.Controls.Add(this.label8);
            this.groupBox2.Location = new System.Drawing.Point(25, 204);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(468, 59);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Datos Alumno";
            // 
            // boxCraest
            // 
            this.boxCraest.Location = new System.Drawing.Point(299, 27);
            this.boxCraest.Name = "boxCraest";
            this.boxCraest.Size = new System.Drawing.Size(115, 20);
            this.boxCraest.TabIndex = 16;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(251, 30);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(43, 13);
            this.label9.TabIndex = 15;
            this.label9.Text = "Craest :";
            // 
            // boxCodigoPucp
            // 
            this.boxCodigoPucp.Location = new System.Drawing.Point(109, 27);
            this.boxCodigoPucp.Name = "boxCodigoPucp";
            this.boxCodigoPucp.Size = new System.Drawing.Size(115, 20);
            this.boxCodigoPucp.TabIndex = 14;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(15, 30);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(78, 13);
            this.label8.TabIndex = 14;
            this.label8.Text = "Código PUCP :";
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.boxEstado);
            this.groupBox3.Controls.Add(this.label11);
            this.groupBox3.Controls.Add(this.boxCodigoProf);
            this.groupBox3.Controls.Add(this.label10);
            this.groupBox3.Location = new System.Drawing.Point(25, 280);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(468, 65);
            this.groupBox3.TabIndex = 2;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Datos Profesor :";
            // 
            // boxEstado
            // 
            this.boxEstado.Location = new System.Drawing.Point(299, 30);
            this.boxEstado.Name = "boxEstado";
            this.boxEstado.ScrollBars = System.Windows.Forms.ScrollBars.Horizontal;
            this.boxEstado.Size = new System.Drawing.Size(115, 20);
            this.boxEstado.TabIndex = 18;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(251, 33);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(46, 13);
            this.label11.TabIndex = 17;
            this.label11.Text = "Estado :";
            // 
            // boxCodigoProf
            // 
            this.boxCodigoProf.Location = new System.Drawing.Point(109, 30);
            this.boxCodigoProf.Name = "boxCodigoProf";
            this.boxCodigoProf.Size = new System.Drawing.Size(115, 20);
            this.boxCodigoProf.TabIndex = 17;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(15, 33);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(88, 13);
            this.label10.TabIndex = 17;
            this.label10.Text = "Código Profesor :";
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.boxDedicacion);
            this.groupBox4.Controls.Add(this.label12);
            this.groupBox4.Location = new System.Drawing.Point(25, 361);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(468, 51);
            this.groupBox4.TabIndex = 3;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Datos Personal Externo";
            // 
            // boxDedicacion
            // 
            this.boxDedicacion.FormattingEnabled = true;
            this.boxDedicacion.Items.AddRange(new object[] {
            "Total",
            "Parcial"});
            this.boxDedicacion.Location = new System.Drawing.Point(109, 19);
            this.boxDedicacion.Name = "boxDedicacion";
            this.boxDedicacion.Size = new System.Drawing.Size(115, 21);
            this.boxDedicacion.TabIndex = 14;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(19, 26);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(67, 13);
            this.label12.TabIndex = 19;
            this.label12.Text = "Dedicación :";
            // 
            // btnGrabar
            // 
            this.btnGrabar.Location = new System.Drawing.Point(160, 434);
            this.btnGrabar.Name = "btnGrabar";
            this.btnGrabar.Size = new System.Drawing.Size(75, 23);
            this.btnGrabar.TabIndex = 4;
            this.btnGrabar.Text = "Grabar";
            this.btnGrabar.UseVisualStyleBackColor = true;
            this.btnGrabar.Click += new System.EventHandler(this.btnGrabar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Location = new System.Drawing.Point(279, 434);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(75, 23);
            this.btnCancelar.TabIndex = 5;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.UseVisualStyleBackColor = true;
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // frmMantMiemEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(505, 469);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.btnGrabar);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "frmMantMiemEditor";
            this.Text = "frmMiembroNuevo";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmMantMiemEditor_FormClosed);
            this.Load += new System.EventHandler(this.frmMantMiemEditor_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker boxTimePicker;
        private System.Windows.Forms.TextBox boxEmail;
        private System.Windows.Forms.TextBox boxDireccion;
        private System.Windows.Forms.TextBox boxNombre;
        private System.Windows.Forms.TextBox boxCodigo;
        private System.Windows.Forms.ComboBox boxTipo;
        private System.Windows.Forms.ComboBox boxSexo;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.TextBox boxCraest;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TextBox boxCodigoPucp;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.TextBox boxEstado;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.TextBox boxCodigoProf;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.ComboBox boxDedicacion;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Button btnGrabar;
        private System.Windows.Forms.Button btnCancelar;
    }
}