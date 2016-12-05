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
    public partial class frmEventoNuevo : Form
    {
        private EQuipuServiceClient _serviceClient;
        private Evento _evento;

        private List<Equipo> _equipos;
        private List<Exposicion> _exposiciones;

        public frmEventoNuevo()
        {
            InitializeComponent();
            _serviceClient = new EQuipuServiceClient();
            _evento = null;
            _equipos = new List<Equipo>();
            _exposiciones = new List<Exposicion>();
            this.Text = "Nuevo Evento";
        }

        public frmEventoNuevo(string nombre)
        {
            InitializeComponent();
            _serviceClient = new EQuipuServiceClient();
            _equipos = new List<Equipo>();
            _exposiciones = new List<Exposicion>();
            _evento = _serviceClient.ObtenerEvento(nombre);
            this.Text = "Editar Evento";
        }

        private void frmEventoNuevo_Load(object sender, EventArgs e)
        {
            if (_evento != null)
            {
                this.nombreBox.Enabled = false;
                this.nombreBox.Text = _evento.Nombre;
                this.categoriaBox.Text = _evento.CategoriaEquipo;
                this.cantEntraBox.Text = _evento.NumEntradas.ToString();
                this.precioEntBox.Text = _evento.PrecioEntrada.ToString();

                cargarGrillaEquipos(_evento.Equipos);
                cargarGrillaExposiciones(_evento.Exposiciones);
            }
        }

        private void cargarGrillaEquipos(List<Equipo> lista)
        {
            this.equiposEnEventoGrid.Rows.Clear();
            foreach (Equipo eq in lista)
            {
                string[] row = new string[3];
                row[0] = eq.Nombre;
                row[1] = eq.Categoria;
                row[2] = eq.Fondo.ToString();
                this.equiposEnEventoGrid.Rows.Add(row);
            }
        }

        private void cargarGrillaExposiciones(List<Exposicion> lista)
        {
            this.exposicionesGrid.Rows.Clear();
            foreach (Exposicion ex in lista)
            {
                string[] row = new string[4];
                row[0] = ex.FechaParticipacion;
                row[1] = ex.HoraParticipacion.ToString();
                row[2] = ex.LugarParticipacion;
                row[3] = ex.CantidadAsistentes.ToString();
                this.exposicionesGrid.Rows.Add(row);
            }
        }

        private void agregarEquipoBtn_Click(object sender, EventArgs e)
        {

        }

        private void eliminarEquipoBtn_Click(object sender, EventArgs e)
        {

        }

        private void agregarExpoBtn_Click(object sender, EventArgs e)
        {

        }

        private void eliminarExpoBtn_Click(object sender, EventArgs e)
        {

        }

        private void grabarBtn_Click(object sender, EventArgs e)
        {
            if (_evento == null)
            {
                string nombre = this.nombreBox.Text;
                string categoria = this.categoriaBox.SelectedItem.ToString();
                int numEntradas = Int32.Parse(this.cantEntraBox.Text);
                double precioEntradas = Double.Parse(this.precioEntBox.Text);
                Evento ev = _serviceClient.CrearEvento(nombre, categoria, numEntradas, precioEntradas);
                foreach (Equipo eq in _equipos)
                {
                    _serviceClient.AgregarEquipoAEvento(ev, eq);
                }
                foreach (Exposicion ex in _exposiciones)
                {
                    _serviceClient.AgregarExposicionAEvento(ev, ex);
                }
                _serviceClient.AgregarEvento(ev);
            }
            else
            {
                _evento.Nombre = this.nombreBox.Text;
                _evento.CategoriaEquipo = this.categoriaBox.SelectedItem.ToString();
                _evento.NumEntradas = Int32.Parse(this.cantEntraBox.Text);
                _evento.PrecioEntrada = Double.Parse(this.precioEntBox.Text);
                _evento.Equipos = _equipos;
                _evento.Exposiciones = _exposiciones;
                _serviceClient.ActualizarEvento(_evento);
            }
            this.Close();
        }

        private void cancelBtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmEventoNuevo_FormClosed(object sender, FormClosedEventArgs e)
        {
            _serviceClient.Close();
        }
    }
}

