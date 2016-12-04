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
    public partial class frmMantEquiEditorAgregarMiem : Form
    {
        private EQuipuServiceClient _serviceClient;
        private List<Miembro> _lista;
        private List<Miembro> _alreadyThere;
        public frmMantEquiEditorAgregarMiem(List<Miembro> list, EQuipuServiceClient sc, List<Miembro> ll)
        {
            InitializeComponent();
            _serviceClient = sc;
            _lista = list;
            _alreadyThere = ll;
        }

        private void okBtn_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < this.miembroGrilla.SelectedRows.Count; i++)
            {
                int codigoMiembro = Convert.ToInt32(this.miembroGrilla.SelectedRows[i].Cells[0].Value);
                _lista.Add(_serviceClient.ObtenerMiembro(codigoMiembro));
            }
            this.Close();
        }

        private void buscarBtn_Click(object sender, EventArgs e)
        {
            int codigo;
            try
            { 
                codigo = Convert.ToInt32(this.boxCodigoMiembro.Text);
            }
            catch
            {
                codigo = -1;
            }
            List<Miembro> lista = _serviceClient.BuscarMiembro(codigo, null);
            cargarGrilla(lista);
        }

        private bool findMiembro(List<Miembro> listaMiembros, int codigo)
        {
            foreach (Miembro m in listaMiembros)
            {
                if (m.Codigo == codigo)
                {
                    return true;
                }
            }
            return false;
        }

        private void cargarGrilla(List<Miembro> listaMiembros)
        {
            this.miembroGrilla.Rows.Clear();
            foreach (Miembro miem in listaMiembros)
            {
                if (!findMiembro(_alreadyThere, miem.Codigo)) { 
                    string[] row = new string[3];
                    row[0] = Convert.ToString(miem.Codigo);
                    row[1] = miem.Nombre;
                    if (miem is Alumno) row[2] = "Alumno";
                    else if (miem is Profesor) row[2] = "Profesor";
                    else if (miem is Externo) row[2] = "Externo";

                    this.miembroGrilla.Rows.Add(row);
                }
            }
        }

        private void frmMantEquiEditorAgregarMiem_Load(object sender, EventArgs e)
        {
            cargarGrilla(_serviceClient.ObtenerMiembros());
        }
    }
}
