using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using EQuipu.EQuipuService;

namespace EQuipu.Vista
{
    public partial class frmMantEquipos : Form
    {
        private EQuipuServiceClient _serviceClient;

        public frmMantEquipos()
        {
            InitializeComponent();
            this._serviceClient = new EQuipuServiceClient();
        }

        private void cargarGrilla(List<Equipo> listaEquipos)
        {
            this.dataGridView1.Rows.Clear();
            foreach (Equipo equi in listaEquipos)
            {
                string[] row = new string[4];
                row[0] = equi.Nombre;
                row[1] = equi.Interes;
                row[2] = equi.Categoria;
                row[3] = Convert.ToString(equi.Fondo);

                this.dataGridView1.Rows.Add(row);
            }
        }

        private void frmMantEquipos_Load(object sender, EventArgs e)
        {
            this.cargarGrilla(_serviceClient.ObtenerEquipos());
        }

        private void frmMantEquipos_FormClosed(object sender, FormClosedEventArgs e)
        {
            this._serviceClient.Close();
        }

        private void buscarBtn_Click(object sender, EventArgs e)
        {
            string categoria;
            try
            {
                categoria = this.comboBox1.SelectedItem.ToString();
            }
            catch
            {
                categoria = null;
            }
            List<Equipo> lista = null;

            lista = _serviceClient.BuscarEquipos(categoria);
            this.cargarGrilla(lista);
        }

        private void nuevoBtn_Click(object sender, EventArgs e)
        {
            frmMantEquiEditor editor = new frmMantEquiEditor();
            editor.ShowDialog();
            this.cargarGrilla(this._serviceClient.ObtenerEquipos());
        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            string nombre = (string) this.dataGridView1.SelectedRows[0].Cells[0].Value;
            _serviceClient.EliminarEquipo(nombre);
            this.cargarGrilla(this._serviceClient.ObtenerEquipos()); 
        }

        private void editBtn_Click(object sender, EventArgs e)
        {
            string nombre = (string) this.dataGridView1.SelectedRows[0].Cells[0].Value;
            frmMantEquiEditor editor = new frmMantEquiEditor(nombre);
            editor.ShowDialog();
            this.cargarGrilla(this._serviceClient.ObtenerEquipos());
        }
    }
}
