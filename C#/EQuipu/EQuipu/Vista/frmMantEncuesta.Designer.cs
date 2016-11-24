namespace EQuipu.Vista
{
    partial class frmMantEncuesta
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
            this.textBox = new System.Windows.Forms.TextBox();
            this.ptMinBox = new System.Windows.Forms.TextBox();
            this.ptMaxBox = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.preguntasGrid = new System.Windows.Forms.DataGridView();
            this.texto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ptMin = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ptMax = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnOk = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.preguntasGrid)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // textBox
            // 
            this.textBox.Location = new System.Drawing.Point(113, 29);
            this.textBox.Name = "textBox";
            this.textBox.Size = new System.Drawing.Size(141, 20);
            this.textBox.TabIndex = 0;
            // 
            // ptMinBox
            // 
            this.ptMinBox.Location = new System.Drawing.Point(113, 55);
            this.ptMinBox.Name = "ptMinBox";
            this.ptMinBox.Size = new System.Drawing.Size(141, 20);
            this.ptMinBox.TabIndex = 1;
            // 
            // ptMaxBox
            // 
            this.ptMaxBox.Location = new System.Drawing.Point(113, 81);
            this.ptMaxBox.Name = "ptMaxBox";
            this.ptMaxBox.Size = new System.Drawing.Size(141, 20);
            this.ptMaxBox.TabIndex = 2;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(270, 79);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 3;
            this.button1.Text = "Agregar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // preguntasGrid
            // 
            this.preguntasGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.preguntasGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.texto,
            this.ptMin,
            this.ptMax});
            this.preguntasGrid.Location = new System.Drawing.Point(12, 152);
            this.preguntasGrid.Name = "preguntasGrid";
            this.preguntasGrid.Size = new System.Drawing.Size(361, 171);
            this.preguntasGrid.TabIndex = 4;
            // 
            // texto
            // 
            this.texto.HeaderText = "Texto";
            this.texto.Name = "texto";
            // 
            // ptMin
            // 
            this.ptMin.HeaderText = "Puntaje Minimo";
            this.ptMin.Name = "ptMin";
            // 
            // ptMax
            // 
            this.ptMax.HeaderText = "PuntajeMaximo";
            this.ptMax.Name = "ptMax";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(73, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Texto";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(28, 58);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(79, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Puntaje Minimo";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(25, 84);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Puntaje Maximo";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.ptMaxBox);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.ptMinBox);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.textBox);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(361, 134);
            this.groupBox1.TabIndex = 8;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Agregar Pregunta";
            // 
            // btnOk
            // 
            this.btnOk.Location = new System.Drawing.Point(146, 336);
            this.btnOk.Name = "btnOk";
            this.btnOk.Size = new System.Drawing.Size(75, 23);
            this.btnOk.TabIndex = 9;
            this.btnOk.Text = "Ok";
            this.btnOk.UseVisualStyleBackColor = true;
            this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
            // 
            // frmMantEncuesta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(385, 371);
            this.Controls.Add(this.btnOk);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.preguntasGrid);
            this.Name = "frmMantEncuesta";
            this.Text = "frmMantEncuesta";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmMantEncuesta_FormClosed);
            this.Load += new System.EventHandler(this.frmMantEncuesta_Load);
            ((System.ComponentModel.ISupportInitialize)(this.preguntasGrid)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox textBox;
        private System.Windows.Forms.TextBox ptMinBox;
        private System.Windows.Forms.TextBox ptMaxBox;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.DataGridView preguntasGrid;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnOk;
        private System.Windows.Forms.DataGridViewTextBoxColumn texto;
        private System.Windows.Forms.DataGridViewTextBoxColumn ptMin;
        private System.Windows.Forms.DataGridViewTextBoxColumn ptMax;
    }
}