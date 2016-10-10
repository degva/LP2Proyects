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
    public partial class frmMantMiemEditor : Form
    {
        GestorMiembros _gestor;
        int _codigo;
        public frmMantMiemEditor(GestorMiembros gestor)
        {
            InitializeComponent();
            this._gestor = gestor;
            this.btnGrabar.Text = "Crear";
            this._codigo = -1;
            this.Text = "Crear nuevo miembro";
        }

        public frmMantMiemEditor(GestorMiembros gestor, int codigo)
        {
            InitializeComponent();
            this._gestor = gestor;
            this.btnGrabar.Text = "Grabar";
            this._codigo = codigo;
            this.Text = "Editar miembro";
        }

        private void frmMantMiemEditor_Load(object sender, EventArgs e)
        {
            if (_codigo != -1)
            {
                this.boxCodigo.Enabled = false;
                Miembro miem = _gestor.ObtenerMiembro(this._codigo);
                if (miem is Alumno)
                {
                    Alumno aux = (Alumno)miem;

                    this.boxCodigoProf.Enabled = false;
                    this.boxEstado.Enabled = false;
                    this.boxDedicacion.Enabled = false;

                    this.boxCodigoPucp.Text = Convert.ToString(aux.CodigoAlumno);
                    this.boxCraest.Text = Convert.ToString(aux.Craest);
                }
                else if (miem is Profesor)
                {
                    Profesor aux = (Profesor)miem;

                    this.boxCodigoPucp.Enabled = false;
                    this.boxCraest.Enabled = false;
                    this.boxDedicacion.Enabled = false;

                    this.boxCodigoProf.Text = Convert.ToString(aux.CodigoProfesor);
                    this.boxEstado.Text = Convert.ToString(aux.Estado);
                }
                else if (miem is Externo)
                {
                    Externo aux = (Externo)miem;

                    this.boxCodigoPucp.Enabled = false;
                    this.boxCraest.Enabled = false;
                    this.boxCodigoProf.Enabled = false;
                    this.boxEstado.Enabled = false;

                    // Ver si esto realmente funciona :v
                    this.boxDedicacion.Text = aux.Dedicacion;
                }

                this.boxCodigo.Text = Convert.ToString(miem.Codigo);
                this.boxNombre.Text = miem.Nombre;
                this.boxTimePicker.Value = DateTime.ParseExact(miem.FechaNacimiento, "MM/d/yyyy", System.Globalization.CultureInfo.InvariantCulture);
                this.boxDireccion.Text = miem.Direccion;
                this.boxEmail.Text = miem.Email;
                if (miem.Sexo == 'M')
                {
                    this.boxSexo.Select(0,1);
                }
                else if (miem.Sexo == 'F')
                {
                    this.boxSexo.Select(1, 1);
                }
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnGrabar_Click(object sender, EventArgs e)
        {
            Miembro aux = null;
            int codigo = Convert.ToInt32(this.boxCodigo.Text);
            string nombre = this.boxNombre.Text;
            string fechaNac = this.boxTimePicker.Text;
            string direccion = this.boxDireccion.Text;
            string email = this.boxEmail.Text;

            char sexo;
            if (this.boxSexo.Text == "Masculino") sexo = 'M';
            else sexo = 'F';

            if (this.boxTipo.SelectedItem == "Alumno")
            {
                int codigoPucp = Convert.ToInt32(this.boxCodigoPucp.Text);
                double craest = Convert.ToDouble(this.boxCraest.Text);

                aux = new Alumno(codigo, nombre, fechaNac, direccion, email, sexo, codigoPucp, craest);
            }
            else if (this.boxTipo.SelectedItem == "Profesor")
            {
                int codigoProf = Convert.ToInt32(this.boxCodigoProf.Text);
                string estado = this.boxEstado.Text;

                aux = new Profesor(codigo, nombre, fechaNac, direccion, email, sexo, codigoProf, estado);
            }
            else if (this.boxTipo.SelectedItem == "Externo")
            {
                string dedicacion = this.boxDedicacion.Text;

                aux = new Externo(codigo, nombre, fechaNac, direccion, email, sexo, dedicacion);
            }

            if (this._codigo == -1) {
                _gestor.AgregarMiembro(aux);
                MessageBox.Show("Agregado");
            }
            else
            { 
                _gestor.ActualizarMiembro(aux);
                MessageBox.Show("Actualizado");
            }

            this.Close();
        }

        private void boxTipo_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.boxTipo.SelectedItem == "Alumno")
            {
                this.boxCodigoProf.Enabled = false;
                this.boxEstado.Enabled = false;
                this.boxDedicacion.Enabled = false;

                this.boxCodigoPucp.Enabled = true;
                this.boxCraest.Enabled = true;
            }
            else if (this.boxTipo.SelectedItem == "Profesor")
            {
                this.boxCodigoPucp.Enabled = false;
                this.boxCraest.Enabled = false;
                this.boxDedicacion.Enabled = false;

                this.boxCodigoProf.Enabled = true;
                this.boxEstado.Enabled = true;
            }
            else if (this.boxTipo.SelectedItem == "Externo")
            {
                this.boxCodigoPucp.Enabled = false;
                this.boxCraest.Enabled = false;
                this.boxCodigoProf.Enabled = false;
                this.boxEstado.Enabled = false;

                this.boxDedicacion.Enabled = true;
            }
        }
    }
}
