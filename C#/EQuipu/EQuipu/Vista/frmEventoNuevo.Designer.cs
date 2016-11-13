namespace EQuipu.Vista
{
    partial class frmEventoNuevo
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
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.eliminarEquipoBtn = new System.Windows.Forms.Button();
            this.agregarExpoBtn = new System.Windows.Forms.Button();
            this.agregarEquipoBtn = new System.Windows.Forms.Button();
            this.equiposEnEventoGrid = new System.Windows.Forms.DataGridView();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.precioEntBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.cantEntraBox = new System.Windows.Forms.TextBox();
            this.categoriaBox = new System.Windows.Forms.ComboBox();
            this.nombreBox = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.button3 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.eliminarExpoBtn = new System.Windows.Forms.Button();
            this.exposicionesGrid = new System.Windows.Forms.DataGridView();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.categoria = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fondo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.equiposEnEventoGrid)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.exposicionesGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.eliminarEquipoBtn);
            this.groupBox2.Controls.Add(this.agregarExpoBtn);
            this.groupBox2.Controls.Add(this.agregarEquipoBtn);
            this.groupBox2.Controls.Add(this.equiposEnEventoGrid);
            this.groupBox2.Location = new System.Drawing.Point(22, 170);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(500, 185);
            this.groupBox2.TabIndex = 3;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Equipos del Evento";
            // 
            // eliminarEquipoBtn
            // 
            this.eliminarEquipoBtn.Location = new System.Drawing.Point(415, 82);
            this.eliminarEquipoBtn.Name = "eliminarEquipoBtn";
            this.eliminarEquipoBtn.Size = new System.Drawing.Size(75, 23);
            this.eliminarEquipoBtn.TabIndex = 7;
            this.eliminarEquipoBtn.Text = "Eliminar";
            this.eliminarEquipoBtn.UseVisualStyleBackColor = true;
            this.eliminarEquipoBtn.Click += new System.EventHandler(this.eliminarEquipoBtn_Click);
            // 
            // agregarExpoBtn
            // 
            this.agregarExpoBtn.Location = new System.Drawing.Point(412, 119);
            this.agregarExpoBtn.Name = "agregarExpoBtn";
            this.agregarExpoBtn.Size = new System.Drawing.Size(75, 35);
            this.agregarExpoBtn.TabIndex = 1;
            this.agregarExpoBtn.Text = "Agregar exposicion";
            this.agregarExpoBtn.UseVisualStyleBackColor = true;
            this.agregarExpoBtn.Click += new System.EventHandler(this.agregarExpoBtn_Click);
            // 
            // agregarEquipoBtn
            // 
            this.agregarEquipoBtn.Location = new System.Drawing.Point(414, 45);
            this.agregarEquipoBtn.Name = "agregarEquipoBtn";
            this.agregarEquipoBtn.Size = new System.Drawing.Size(75, 23);
            this.agregarEquipoBtn.TabIndex = 1;
            this.agregarEquipoBtn.Text = "Agregar";
            this.agregarEquipoBtn.UseVisualStyleBackColor = true;
            this.agregarEquipoBtn.Click += new System.EventHandler(this.agregarEquipoBtn_Click);
            // 
            // equiposEnEventoGrid
            // 
            this.equiposEnEventoGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.equiposEnEventoGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column2,
            this.categoria,
            this.fondo});
            this.equiposEnEventoGrid.Location = new System.Drawing.Point(6, 20);
            this.equiposEnEventoGrid.MultiSelect = false;
            this.equiposEnEventoGrid.Name = "equiposEnEventoGrid";
            this.equiposEnEventoGrid.Size = new System.Drawing.Size(390, 150);
            this.equiposEnEventoGrid.TabIndex = 0;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.precioEntBox);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.cantEntraBox);
            this.groupBox1.Controls.Add(this.categoriaBox);
            this.groupBox1.Controls.Add(this.nombreBox);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Location = new System.Drawing.Point(22, 23);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(500, 132);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Datos Generales";
            // 
            // precioEntBox
            // 
            this.precioEntBox.Location = new System.Drawing.Point(348, 98);
            this.precioEntBox.Margin = new System.Windows.Forms.Padding(2);
            this.precioEntBox.Name = "precioEntBox";
            this.precioEntBox.Size = new System.Drawing.Size(76, 20);
            this.precioEntBox.TabIndex = 8;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(257, 101);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(87, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Precio entradas: ";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(27, 101);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(99, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "Cantidad entradas: ";
            // 
            // cantEntraBox
            // 
            this.cantEntraBox.Location = new System.Drawing.Point(131, 98);
            this.cantEntraBox.Margin = new System.Windows.Forms.Padding(2);
            this.cantEntraBox.Name = "cantEntraBox";
            this.cantEntraBox.Size = new System.Drawing.Size(111, 20);
            this.cantEntraBox.TabIndex = 5;
            // 
            // categoriaBox
            // 
            this.categoriaBox.Items.AddRange(new object[] {
            "Tecnología",
            "Servicio Social",
            "Educación",
            "Manualidades"});
            this.categoriaBox.Location = new System.Drawing.Point(92, 66);
            this.categoriaBox.Name = "categoriaBox";
            this.categoriaBox.Size = new System.Drawing.Size(111, 21);
            this.categoriaBox.TabIndex = 4;
            // 
            // nombreBox
            // 
            this.nombreBox.Location = new System.Drawing.Point(92, 36);
            this.nombreBox.Name = "nombreBox";
            this.nombreBox.Size = new System.Drawing.Size(273, 20);
            this.nombreBox.TabIndex = 3;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(27, 69);
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
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(287, 644);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(75, 23);
            this.button3.TabIndex = 5;
            this.button3.Text = "Cancelar";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(191, 644);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 4;
            this.button2.Text = "Grabar";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.eliminarExpoBtn);
            this.groupBox3.Controls.Add(this.exposicionesGrid);
            this.groupBox3.Location = new System.Drawing.Point(22, 377);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(500, 261);
            this.groupBox3.TabIndex = 6;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Exposiciones del Evento";
            // 
            // eliminarExpoBtn
            // 
            this.eliminarExpoBtn.Location = new System.Drawing.Point(217, 215);
            this.eliminarExpoBtn.Name = "eliminarExpoBtn";
            this.eliminarExpoBtn.Size = new System.Drawing.Size(75, 23);
            this.eliminarExpoBtn.TabIndex = 7;
            this.eliminarExpoBtn.Text = "Eliminar";
            this.eliminarExpoBtn.UseVisualStyleBackColor = true;
            this.eliminarExpoBtn.Click += new System.EventHandler(this.eliminarExpoBtn_Click);
            // 
            // exposicionesGrid
            // 
            this.exposicionesGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.exposicionesGrid.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.Column4,
            this.Column5});
            this.exposicionesGrid.Location = new System.Drawing.Point(6, 24);
            this.exposicionesGrid.MultiSelect = false;
            this.exposicionesGrid.Name = "exposicionesGrid";
            this.exposicionesGrid.Size = new System.Drawing.Size(488, 185);
            this.exposicionesGrid.TabIndex = 0;
            // 
            // Column2
            // 
            this.Column2.HeaderText = "Nombre";
            this.Column2.Name = "Column2";
            // 
            // categoria
            // 
            this.categoria.HeaderText = "Categoria";
            this.categoria.Name = "categoria";
            // 
            // fondo
            // 
            this.fondo.HeaderText = "Fondo";
            this.fondo.Name = "fondo";
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.HeaderText = "Dia";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.HeaderText = "Hora";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // Column4
            // 
            this.Column4.HeaderText = "Lugar";
            this.Column4.Name = "Column4";
            // 
            // Column5
            // 
            this.Column5.HeaderText = "Cantidad entradas";
            this.Column5.Name = "Column5";
            // 
            // frmEventoNuevo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(548, 686);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "frmEventoNuevo";
            this.Text = "frmEventoNuevo";
            this.Load += new System.EventHandler(this.frmEventoNuevo_Load);
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.equiposEnEventoGrid)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.exposicionesGrid)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button eliminarEquipoBtn;
        private System.Windows.Forms.Button agregarEquipoBtn;
        private System.Windows.Forms.DataGridView equiposEnEventoGrid;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ComboBox categoriaBox;
        private System.Windows.Forms.TextBox nombreBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox cantEntraBox;
        private System.Windows.Forms.TextBox precioEntBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button eliminarExpoBtn;
        private System.Windows.Forms.Button agregarExpoBtn;
        private System.Windows.Forms.DataGridView exposicionesGrid;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn categoria;
        private System.Windows.Forms.DataGridViewTextBoxColumn fondo;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column4;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column5;
    }
}