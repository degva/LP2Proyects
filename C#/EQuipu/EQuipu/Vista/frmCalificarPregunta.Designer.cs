namespace EQuipu.Vista
{
    partial class frmCalificarPregunta
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
            this.pregBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.califBox = new System.Windows.Forms.TextBox();
            this.btnOk = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Pregunta:";
            // 
            // pregBox
            // 
            this.pregBox.Location = new System.Drawing.Point(100, 13);
            this.pregBox.Multiline = true;
            this.pregBox.Name = "pregBox";
            this.pregBox.Size = new System.Drawing.Size(172, 86);
            this.pregBox.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 108);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Calificacion:";
            // 
            // califBox
            // 
            this.califBox.Location = new System.Drawing.Point(100, 105);
            this.califBox.Name = "califBox";
            this.califBox.Size = new System.Drawing.Size(100, 20);
            this.califBox.TabIndex = 3;
            // 
            // btnOk
            // 
            this.btnOk.Location = new System.Drawing.Point(100, 131);
            this.btnOk.Name = "btnOk";
            this.btnOk.Size = new System.Drawing.Size(75, 23);
            this.btnOk.TabIndex = 4;
            this.btnOk.Text = "Aceptar";
            this.btnOk.UseVisualStyleBackColor = true;
            this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
            // 
            // frmCalificarPregunta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 164);
            this.Controls.Add(this.btnOk);
            this.Controls.Add(this.califBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.pregBox);
            this.Controls.Add(this.label1);
            this.Name = "frmCalificarPregunta";
            this.Text = "frmCalificarPregunta";
            this.Load += new System.EventHandler(this.frmCalificarPregunta_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox pregBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox califBox;
        private System.Windows.Forms.Button btnOk;
    }
}