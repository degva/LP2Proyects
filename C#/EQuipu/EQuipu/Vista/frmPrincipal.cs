using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EQuipu.Vista
{
    public partial class frmPrincipal : Form
    {
        public frmPrincipal()
        {
            InitializeComponent();
        }

        private void miembrosMantMenuItem_Click(object sender, EventArgs e)
        {
            frmMantMiembros ventanaMantMiembros = new frmMantMiembros();
            ventanaMantMiembros.MdiParent = this;
            ventanaMantMiembros.Show();
        }

        private void equiposMantMenuItem_Click(object sender, EventArgs e)
        {
            frmMantEquipos ventanaMantEquipos = new frmMantEquipos();
            ventanaMantEquipos.MdiParent = this;
            ventanaMantEquipos.Show();
        }
    }
}
