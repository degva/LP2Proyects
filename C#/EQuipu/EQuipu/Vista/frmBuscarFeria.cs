using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using EQuipu.Modelo;
using EQuipu.Controlador;

namespace EQuipu.Vista
{
    public partial class frmBuscarFeria : Form
    {

        private List<Feria> _ferias;
        public string name;

        public frmBuscarFeria(List<Feria> _ferias)
        {
            InitializeComponent();
            this._ferias = _ferias;
        }

        public string getFeria()
        {
            return name;
        }

        private void CargarGrilla(List<Feria> ferias)
        {
            for (int i = 0; i < ferias.Count; i++)
            {
                this.feriasComboBox.Items.Add(ferias[i].Nombre);
            }
        }

        private void okBtn_Click(object sender, EventArgs e)
        {
            name = this.feriasComboBox.SelectedItem.ToString();
            this.Hide();
        }

        private void frmBuscarFeria_Load(object sender, EventArgs e)
        {
            CargarGrilla(_ferias);
        }
    }
}
