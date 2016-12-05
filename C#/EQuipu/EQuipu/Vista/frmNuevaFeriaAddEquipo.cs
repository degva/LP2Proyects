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

/*
 * Nombre: Diego Pavel Vargas Flores
 * Examen 1
 */

namespace EQuipu.Vista
{
    public partial class frmNewFairAddTeam : Form
    {
        private EQuipuServiceClient _serviceClient;
        private List<Equipo> _listaEquipos;
        private int _idx;
        public frmNewFairAddTeam(List<Equipo> lista, int idx)
        {
            InitializeComponent();
            _serviceClient = new EQuipuServiceClient();
            _listaEquipos = lista;
            _idx = idx;
        }

        private bool findEquipo(List<Equipo> listaEquipos, string nombre)
        {
            foreach (Equipo e in listaEquipos)
            {
                if (e.Nombre == nombre)
                {
                    return true;
                }
            }
            return false;
        }

        private void okBtn_Click(object sender, EventArgs e)
        {
            if (this.dataGridView1.SelectedRows.Count != 0) { 
                string nombreEquipo = this.dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
                _listaEquipos.Insert(_idx, _serviceClient.ObtenerEquipo(nombreEquipo));
                this.Close();
            }
            else
            {
                MessageBox.Show("Selecciona un equipo en la columna extrema izquierda");
            }
        }

        private void cargarGrilla(List<Equipo> listaEquipos)
        {
            this.dataGridView1.Rows.Clear();
            foreach (Equipo eq in listaEquipos)
            {
                if (!findEquipo(_listaEquipos, eq.Nombre))
                {
                    string[] row = new string[2];
                    row[0] = eq.Nombre;
                    row[1] = eq.Categoria;
                    this.dataGridView1.Rows.Add(row);
                }
            }
        }

        private void frmNewFairAddTeam_Load(object sender, EventArgs e)
        {
            cargarGrilla(_serviceClient.ObtenerEquipos());
        }

        private void buscarBtn_Click(object sender, EventArgs e)
        {
            string nombre = this.nombreBox.Text;
            List<Equipo> buscados = _serviceClient.BuscarEquiposPorNombre(nombre);
            cargarGrilla(buscados);
        }

    }
}
