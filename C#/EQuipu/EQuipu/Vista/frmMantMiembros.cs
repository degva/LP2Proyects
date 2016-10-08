using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using EQuipu.Controlador;
using EQuipu.Modelo;

namespace EQuipu.Vista
{
    public partial class frmMantMiembros : Form
    {
        private GestorMiembros _gestorMiem;
        public frmMantMiembros()
        {
            InitializeComponent();
            this._gestorMiem = new GestorMiembros();
        }

        private void frmMantMiembros_Load(object sender, EventArgs e)
        {
            this._gestorMiem.Deserializar();
            this.cargarGrilla(_gestorMiem.ListaMiembros);
        }

        private void cargarGrilla(List<Miembro> listaMiembros)
        {
            this.dataGridView1.Rows.Clear();
            foreach (Miembro miem in listaMiembros)
            {
                string[] row = new string[5];
                row[0] = Convert.ToString(miem.Codigo);
                row[1] = miem.Nombre;

                if (miem is Alumno)
                {
                    row[2] = "Alumno";
                }
                else if (miem is Profesor)
                {
                    row[2] = "Profesor";
                }
                else if (miem is Externo)
                {
                    row[2] = "Externo";
                }

                row[3] = miem.Email;
                row[4] = Convert.ToString(miem.Sexo);

                this.dataGridView1.Rows.Add(row);
            }
        }

        private void frmMantMiembros_FormClosed(object sender, FormClosedEventArgs e)
        {
            this._gestorMiem.Serializar();
        }

        private void nuevoBtn_Click(object sender, EventArgs e)
        {
            frmMantMiemEditor editor = new frmMantMiemEditor(_gestorMiem);
            editor.ShowDialog();
            this.cargarGrilla(_gestorMiem.ListaMiembros);
        }

        private void editBtn_Click(object sender, EventArgs e)
        {
            int codigo = Convert.ToInt32(this.dataGridView1.SelectedRows[0].Cells[0].Value);
            frmMantMiemEditor editor = new frmMantMiemEditor(_gestorMiem, codigo);
            editor.ShowDialog();
            this.cargarGrilla(_gestorMiem.ListaMiembros);
        }

        private void searchBtn_Click(object sender, EventArgs e)
        {
            int codigo;
            string tipo;
            try
            {
                codigo = Convert.ToInt32(this.codigoBox.Text);
            } catch {
                codigo = -1;
            }
            try {
                tipo = this.comboBox1.SelectedItem.ToString();
            } catch {
                tipo = null;
            }
            List<Miembro> lista = null;
            
            lista = _gestorMiem.BuscarMiembro(codigo, tipo);
            this.cargarGrilla(lista);
        }

        private void resetBtn_Click(object sender, EventArgs e)
        {
            this.cargarGrilla(_gestorMiem.ListaMiembros);
        }

        private void eliminarBtn_Click(object sender, EventArgs e)
        {
            int codigo = Convert.ToInt32(this.dataGridView1.SelectedRows[0].Cells[0].Value);
            _gestorMiem.EliminarMiembro(codigo);
            this.cargarGrilla(_gestorMiem.ListaMiembros);
        }


    }
}
