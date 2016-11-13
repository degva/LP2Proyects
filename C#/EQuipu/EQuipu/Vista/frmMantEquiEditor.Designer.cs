namespace EQuipu.Vista
{
    partial class frmMantEquiEditor
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
            this.boxInteres = new System.Windows.Forms.TextBox();
            this.boxCategoria = new System.Windows.Forms.ComboBox();
            this.boxNombre = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.agregarBtn = new System.Windows.Forms.Button();
            this.miembrosEquipoGrid = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.grabarBtn = new System.Windows.Forms.Button();
            this.cancelBtn = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.miembrosEquipoGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.boxInteres);
            this.groupBox1.Controls.Add(this.boxCategoria);
            this.groupBox1.Controls.Add(this.boxNombre);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(22, 27);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(461, 164);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Datos Generales";
            // 
            // boxInteres
            // 
            this.boxInteres.Location = new System.Drawing.Point(92, 71);
            this.boxInteres.Multiline = true;
            this.boxInteres.Name = "boxInteres";
            this.boxInteres.Size = new System.Drawing.Size(272, 46);
            this.boxInteres.TabIndex = 5;
            // 
            // boxCategoria
            // 
            this.boxCategoria.FormattingEnabled = true;
            this.boxCategoria.Items.AddRange(new object[] {
            "Tecnología",
            "Servicio Social",
            "Educación",
            "Manualidades"});
            this.boxCategoria.Location = new System.Drawing.Point(92, 126);
            this.boxCategoria.Name = "boxCategoria";
            this.boxCategoria.Size = new System.Drawing.Size(111, 21);
            this.boxCategoria.TabIndex = 4;
            // 
            // boxNombre
            // 
            this.boxNombre.Location = new System.Drawing.Point(92, 36);
            this.boxNombre.Name = "boxNombre";
            this.boxNombre.Size = new System.Drawing.Size(273, 20);
            this.boxNombre.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(27, 126);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(60, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Categoría :";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(27, 39);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(50, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Nombre :";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(27, 79);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(45, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Interés :";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.agregarBtn);
            this.groupBox2.Controls.Add(this.miembrosEquipoGrid);
            this.groupBox2.Location = new System.Drawing.Point(22, 198);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(461, 185);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Miembros del Equipo";
            // 
            // agregarBtn
            // 
            this.agregarBtn.Location = new System.Drawing.Point(380, 45);
            this.agregarBtn.Name = "agregarBtn";
            this.agregarBtn.Size = new System.Drawing.Size(75, 23);
            this.agregarBtn.TabIndex = 1;
            this.agregarBtn.Text = "Agregar";
            this.agregarBtn.UseVisualStyleBackColor = true;
            this.agregarBtn.Click += new System.EventHandler(this.agregarBtn_Click);
            // 
            // miembrosEquipoGrid
            // 
            this.miembrosEquipoGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.miembrosEquipoGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3});
            this.miembrosEquipoGrid.Location = new System.Drawing.Point(30, 19);
            this.miembrosEquipoGrid.Name = "miembrosEquipoGrid";
            this.miembrosEquipoGrid.Size = new System.Drawing.Size(344, 150);
            this.miembrosEquipoGrid.TabIndex = 0;
            // 
            // Column1
            // 
            this.Column1.HeaderText = "Código";
            this.Column1.Name = "Column1";
            // 
            // Column2
            // 
            this.Column2.HeaderText = "Nombre";
            this.Column2.Name = "Column2";
            // 
            // Column3
            // 
            this.Column3.HeaderText = "Tipo";
            this.Column3.Name = "Column3";
            // 
            // grabarBtn
            // 
            this.grabarBtn.Location = new System.Drawing.Point(150, 389);
            this.grabarBtn.Name = "grabarBtn";
            this.grabarBtn.Size = new System.Drawing.Size(75, 23);
            this.grabarBtn.TabIndex = 2;
            this.grabarBtn.Text = "Grabar";
            this.grabarBtn.UseVisualStyleBackColor = true;
            this.grabarBtn.Click += new System.EventHandler(this.grabarBtn_Click);
            // 
            // cancelBtn
            // 
            this.cancelBtn.Location = new System.Drawing.Point(246, 389);
            this.cancelBtn.Name = "cancelBtn";
            this.cancelBtn.Size = new System.Drawing.Size(75, 23);
            this.cancelBtn.TabIndex = 3;
            this.cancelBtn.Text = "Cancelar";
            this.cancelBtn.UseVisualStyleBackColor = true;
            this.cancelBtn.Click += new System.EventHandler(this.cancelBtn_Click);
            // 
            // frmMantEquiEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(506, 418);
            this.Controls.Add(this.cancelBtn);
            this.Controls.Add(this.grabarBtn);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "frmMantEquiEditor";
            this.Text = "Equipo Nuevo";
            this.Load += new System.EventHandler(this.frmMantEquiEditor_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.miembrosEquipoGrid)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox boxInteres;
        private System.Windows.Forms.ComboBox boxCategoria;
        private System.Windows.Forms.TextBox boxNombre;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView miembrosEquipoGrid;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.Button agregarBtn;
        private System.Windows.Forms.Button grabarBtn;
        private System.Windows.Forms.Button cancelBtn;
    }
}