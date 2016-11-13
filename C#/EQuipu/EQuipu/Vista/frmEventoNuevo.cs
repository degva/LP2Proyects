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
    public partial class frmEventoNuevo : Form
    {
        private GestorEventos _gestorEventos;
        private GestorEquipos _gestorEquipos;
        private Evento _evento;

        public frmEventoNuevo(GestorEventos gv, GestorEquipos ge)
        {
            InitializeComponent();
            _gestorEventos = gv;
            _gestorEquipos = ge;
            _evento = null;
            this.Text = "Nuevo Evento";
        }

        public frmEventoNuevo(GestorEventos gv, GestorEquipos ge, string nombre)
        {
            InitializeComponent();
            _gestorEventos = gv;
            _gestorEquipos = ge;
            _evento = _gestorEventos.ObtenerEvento(nombre);
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
    }
}

