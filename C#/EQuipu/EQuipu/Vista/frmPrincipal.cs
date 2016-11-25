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

        private void eventosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmMantEvento ventanaMantEvento = new frmMantEvento();
            ventanaMantEvento.MdiParent = this;
            ventanaMantEvento.Show();
        }

        private void nuevaFeriaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmNuevaFeria ventanaNuevaFeria = new frmNuevaFeria();
            ventanaNuevaFeria.MdiParent = this;
            ventanaNuevaFeria.Show();
        }

        private void rendirEncuestaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmRendirEncuesta ventanaRendirEncuesta = new frmRendirEncuesta();
            ventanaRendirEncuesta.MdiParent = this;
            ventanaRendirEncuesta.Show();
        }

        private void encuestaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmMantEncuesta v = new frmMantEncuesta();
            v.MdiParent = this;
            v.Show();
        }

        private void procesarEntradasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmProcesarEntrada v = new frmProcesarEntrada();
            v.MdiParent = this;
            v.Show();
        }

        private void frmPrincipal_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
    }
}
