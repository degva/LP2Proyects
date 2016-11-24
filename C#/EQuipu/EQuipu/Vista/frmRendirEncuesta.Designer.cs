namespace EQuipu.Vista
{
    partial class frmRendirEncuesta
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
            this.categoriaComboBox = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.equipoComboBox = new System.Windows.Forms.ComboBox();
            this.preguntasGrid = new System.Windows.Forms.DataGridView();
            this.pregunta = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.calific = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnOk = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.timerLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.preguntasGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(52, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Categoria";
            // 
            // categoriaComboBox
            // 
            this.categoriaComboBox.FormattingEnabled = true;
            this.categoriaComboBox.Items.AddRange(new object[] {
            "Tecnología",
            "Servicio Social",
            "Educación",
            "Manualidades"});
            this.categoriaComboBox.Location = new System.Drawing.Point(151, 10);
            this.categoriaComboBox.Name = "categoriaComboBox";
            this.categoriaComboBox.Size = new System.Drawing.Size(121, 21);
            this.categoriaComboBox.TabIndex = 1;
            this.categoriaComboBox.SelectedIndexChanged += new System.EventHandler(this.categoriaComboBox_SelectedIndexChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 41);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Equipo";
            // 
            // equipoComboBox
            // 
            this.equipoComboBox.FormattingEnabled = true;
            this.equipoComboBox.Location = new System.Drawing.Point(151, 38);
            this.equipoComboBox.Name = "equipoComboBox";
            this.equipoComboBox.Size = new System.Drawing.Size(121, 21);
            this.equipoComboBox.TabIndex = 3;
            this.equipoComboBox.SelectedIndexChanged += new System.EventHandler(this.equipoComboBox_SelectedIndexChanged);
            // 
            // preguntasGrid
            // 
            this.preguntasGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.preguntasGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.pregunta,
            this.calific});
            this.preguntasGrid.Location = new System.Drawing.Point(13, 67);
            this.preguntasGrid.Name = "preguntasGrid";
            this.preguntasGrid.Size = new System.Drawing.Size(259, 158);
            this.preguntasGrid.TabIndex = 4;
            this.preguntasGrid.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.preguntasGrid_CellClick);
            // 
            // pregunta
            // 
            this.pregunta.HeaderText = "Pregunta";
            this.pregunta.Name = "pregunta";
            // 
            // calific
            // 
            this.calific.HeaderText = "Calificacion";
            this.calific.Name = "calific";
            // 
            // btnOk
            // 
            this.btnOk.Location = new System.Drawing.Point(116, 238);
            this.btnOk.Name = "btnOk";
            this.btnOk.Size = new System.Drawing.Size(75, 23);
            this.btnOk.TabIndex = 5;
            this.btnOk.Text = "Grabar";
            this.btnOk.UseVisualStyleBackColor = true;
            this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(197, 238);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(75, 23);
            this.btnCancel.TabIndex = 6;
            this.btnCancel.Text = "Cancelar";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // timerLabel
            // 
            this.timerLabel.AutoSize = true;
            this.timerLabel.Location = new System.Drawing.Point(13, 243);
            this.timerLabel.Name = "timerLabel";
            this.timerLabel.Size = new System.Drawing.Size(35, 13);
            this.timerLabel.TabIndex = 7;
            this.timerLabel.Text = "[timer]";
            // 
            // frmRendirEncuesta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 273);
            this.Controls.Add(this.timerLabel);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnOk);
            this.Controls.Add(this.preguntasGrid);
            this.Controls.Add(this.equipoComboBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.categoriaComboBox);
            this.Controls.Add(this.label1);
            this.Name = "frmRendirEncuesta";
            this.Text = "frmRendirEncuesta";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmRendirEncuesta_FormClosed);
            this.Load += new System.EventHandler(this.frmRendirEncuesta_Load);
            ((System.ComponentModel.ISupportInitialize)(this.preguntasGrid)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox categoriaComboBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox equipoComboBox;
        private System.Windows.Forms.DataGridView preguntasGrid;
        private System.Windows.Forms.DataGridViewTextBoxColumn pregunta;
        private System.Windows.Forms.DataGridViewTextBoxColumn calific;
        private System.Windows.Forms.Button btnOk;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Label timerLabel;
    }
}