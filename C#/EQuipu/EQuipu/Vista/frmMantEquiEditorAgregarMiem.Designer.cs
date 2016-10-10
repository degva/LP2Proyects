namespace EQuipu.Vista
{
    partial class frmMantEquiEditorAgregarMiem
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
            this.boxCodigoMiembro = new System.Windows.Forms.TextBox();
            this.buscarBtn = new System.Windows.Forms.Button();
            this.miembroGrilla = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Column3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.okBtn = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.miembroGrilla)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(36, 38);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Código Miembro :";
            // 
            // boxCodigoMiembro
            // 
            this.boxCodigoMiembro.Location = new System.Drawing.Point(148, 35);
            this.boxCodigoMiembro.Name = "boxCodigoMiembro";
            this.boxCodigoMiembro.Size = new System.Drawing.Size(100, 20);
            this.boxCodigoMiembro.TabIndex = 1;
            // 
            // buscarBtn
            // 
            this.buscarBtn.Location = new System.Drawing.Point(312, 32);
            this.buscarBtn.Name = "buscarBtn";
            this.buscarBtn.Size = new System.Drawing.Size(75, 23);
            this.buscarBtn.TabIndex = 2;
            this.buscarBtn.Text = "Buscar";
            this.buscarBtn.UseVisualStyleBackColor = true;
            this.buscarBtn.Click += new System.EventHandler(this.buscarBtn_Click);
            // 
            // miembroGrilla
            // 
            this.miembroGrilla.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.miembroGrilla.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.Column2,
            this.Column3});
            this.miembroGrilla.Location = new System.Drawing.Point(39, 78);
            this.miembroGrilla.Name = "miembroGrilla";
            this.miembroGrilla.Size = new System.Drawing.Size(348, 154);
            this.miembroGrilla.TabIndex = 3;
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
            // okBtn
            // 
            this.okBtn.Location = new System.Drawing.Point(173, 247);
            this.okBtn.Name = "okBtn";
            this.okBtn.Size = new System.Drawing.Size(75, 23);
            this.okBtn.TabIndex = 4;
            this.okBtn.Text = "Aceptar";
            this.okBtn.UseVisualStyleBackColor = true;
            this.okBtn.Click += new System.EventHandler(this.okBtn_Click);
            // 
            // frmMantEquiEditorAgregarMiem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(420, 282);
            this.Controls.Add(this.okBtn);
            this.Controls.Add(this.miembroGrilla);
            this.Controls.Add(this.buscarBtn);
            this.Controls.Add(this.boxCodigoMiembro);
            this.Controls.Add(this.label1);
            this.Name = "frmMantEquiEditorAgregarMiem";
            this.Text = "Buscar Miembros";
            this.Load += new System.EventHandler(this.frmMantEquiEditorAgregarMiem_Load);
            ((System.ComponentModel.ISupportInitialize)(this.miembroGrilla)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox boxCodigoMiembro;
        private System.Windows.Forms.Button buscarBtn;
        private System.Windows.Forms.DataGridView miembroGrilla;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column2;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column3;
        private System.Windows.Forms.Button okBtn;
    }
}