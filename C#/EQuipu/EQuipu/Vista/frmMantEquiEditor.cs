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
    public partial class frmMantEquiEditor : Form
    {
        private GestorEquipos _gestorEqui;
        private GestorMiembros _gestorMiem;
        private List<Miembro> _miembros;
        public frmMantEquiEditor(GestorEquipos ge, GestorMiembros gm)
        {
            InitializeComponent();
            _gestorEqui = ge;
            _gestorMiem = gm;
            _miembros = new List<Miembro>();
        }

        private void cancelBtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void agregarBtn_Click(object sender, EventArgs e)
        {
            frmMantEquiEditorAgregarMiem agregarMiembro = new frmMantEquiEditorAgregarMiem(_miembros ,_gestorMiem);
            agregarMiembro.ShowDialog();
            cargarGrilla(_miembros);
        }

        private void cargarGrilla(List<Miembro> listaMiembros)
        {
            this.miembrosEquipoGrid.Rows.Clear();
            foreach (Miembro miem in listaMiembros)
            {
                string[] row = new string[3];
                row[0] = Convert.ToString(miem.Codigo);
                row[1] = miem.Nombre;
                if (miem is Alumno) row[2] = "Alumno";
                else if (miem is Profesor) row[2] = "Profesor";
                else if (miem is Externo) row[2] = "Externo";

                this.miembrosEquipoGrid.Rows.Add(row);
            }
        }

        private void grabarBtn_Click(object sender, EventArgs e)
        {
            string nombre = this.boxNombre.Text;
            string interes = this.boxInteres.Text;
            string categoria = this.boxCategoria.SelectedItem.ToString();
            Equipo equ = new Equipo(nombre, interes, categoria);
            foreach (Miembro m in _miembros)
            {
                equ.AddMiembro(m);
            }
            _gestorEqui.AgregarEquipo(equ);
            this.Close();
        }
    }
}
