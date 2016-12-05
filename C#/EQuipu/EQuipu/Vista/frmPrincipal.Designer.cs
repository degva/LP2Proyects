namespace EQuipu.Vista
{
    partial class frmPrincipal
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.mantenimientoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.miembrosMantMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.equiposMantMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eventosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eventosToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.nuevaFeriaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mantenimientoToolStripMenuItem,
            this.eventosToolStripMenuItem1});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(684, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // mantenimientoToolStripMenuItem
            // 
            this.mantenimientoToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.miembrosMantMenuItem,
            this.equiposMantMenuItem,
            this.eventosToolStripMenuItem});
            this.mantenimientoToolStripMenuItem.Name = "mantenimientoToolStripMenuItem";
            this.mantenimientoToolStripMenuItem.Size = new System.Drawing.Size(101, 20);
            this.mantenimientoToolStripMenuItem.Text = "Mantenimiento";
            // 
            // miembrosMantMenuItem
            // 
            this.miembrosMantMenuItem.Name = "miembrosMantMenuItem";
            this.miembrosMantMenuItem.Size = new System.Drawing.Size(152, 22);
            this.miembrosMantMenuItem.Text = "Miembros";
            this.miembrosMantMenuItem.Click += new System.EventHandler(this.miembrosMantMenuItem_Click);
            // 
            // equiposMantMenuItem
            // 
            this.equiposMantMenuItem.Name = "equiposMantMenuItem";
            this.equiposMantMenuItem.Size = new System.Drawing.Size(152, 22);
            this.equiposMantMenuItem.Text = "Equipos";
            this.equiposMantMenuItem.Click += new System.EventHandler(this.equiposMantMenuItem_Click);
            // 
            // eventosToolStripMenuItem
            // 
            this.eventosToolStripMenuItem.Name = "eventosToolStripMenuItem";
            this.eventosToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.eventosToolStripMenuItem.Text = "Eventos";
            this.eventosToolStripMenuItem.Click += new System.EventHandler(this.eventosToolStripMenuItem_Click);
            // 
            // eventosToolStripMenuItem1
            // 
            this.eventosToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.nuevaFeriaToolStripMenuItem});
            this.eventosToolStripMenuItem1.Name = "eventosToolStripMenuItem1";
            this.eventosToolStripMenuItem1.Size = new System.Drawing.Size(60, 20);
            this.eventosToolStripMenuItem1.Text = "Eventos";
            // 
            // nuevaFeriaToolStripMenuItem
            // 
            this.nuevaFeriaToolStripMenuItem.Name = "nuevaFeriaToolStripMenuItem";
            this.nuevaFeriaToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.nuevaFeriaToolStripMenuItem.Text = "Nueva Feria";
            this.nuevaFeriaToolStripMenuItem.Click += new System.EventHandler(this.nuevaFeriaToolStripMenuItem_Click);
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(684, 431);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "frmPrincipal";
            this.Text = "E-Quipu";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmPrincipal_FormClosed);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem mantenimientoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem miembrosMantMenuItem;
        private System.Windows.Forms.ToolStripMenuItem equiposMantMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eventosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eventosToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem nuevaFeriaToolStripMenuItem;
    }
}