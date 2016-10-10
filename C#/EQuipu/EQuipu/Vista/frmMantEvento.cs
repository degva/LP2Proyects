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
    public partial class frmMantEvento : Form
    {
        private GestorEventos _gestorEventos;
        private GestorEquipos _gestorEquipos;

        public frmMantEvento()
        {
            InitializeComponent();
            this._gestorEquipos = new GestorEquipos();
            this._gestorEventos = new GestorEventos();
        }

        private void buscarBtn_Click(object sender, EventArgs e)
        {
            if (this.categoriaBox.Text == string.Empty) //Si no se ha seleccionado ninguna categoria para buscar
            {
                MessageBox.Show("Debe seleccionar una categoria", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else //Cuando ya ha seleccionado una categoria
            {
                //Se debe hacer una busqueda por categoria, entre los eventos
                string categoria = this.categoriaBox.Text;
                List<Evento> listaEventos = this._gestorEventos.BuscarEventosPorCategoria(categoria);
                if (listaEventos.Count == 0)
                {
                    MessageBox.Show("No se encontraron eventos de la categoria selecionada", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    this.categoriaBox.Text = " ";
                    this.CargarGrilla(this._gestorEventos.ListaEventos);
                }
                else
                    this.CargarGrilla(listaEventos);
            }
        }

        private void newBtn_Click(object sender, EventArgs e)
        {
            frmEventoNuevo ventanaEventoNuevo = new frmEventoNuevo(_gestorEventos, _gestorEquipos);
            ventanaEventoNuevo.ShowDialog();
            this.CargarGrilla(this._gestorEventos.ListaEventos);
        }

        private void editBtn_Click(object sender, EventArgs e)
        {
            string nombre = this.dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
            frmEventoNuevo ventanaEventoNuevo = new frmEventoNuevo(_gestorEventos, _gestorEquipos, nombre);
            ventanaEventoNuevo.ShowDialog();
            this.CargarGrilla(this._gestorEventos.ListaEventos);
        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            if (this.dataGridView1.SelectedRows.Count > 0)
            {
                for (int i = 0; i < this.dataGridView1.SelectedRows.Count; i++)
                {
                    //1. Obtenemos el nombre del evento que se quiere Editar
                    int filaSelecionada = this.dataGridView1.SelectedRows[0].Index;
                    string nombreEvento = this.dataGridView1.Rows[filaSelecionada].Cells[0].Value.ToString();
                    this._gestorEventos.EliminarEvento(nombreEvento);
                }
                // this._gestorEventos.Serializar();
                this.CargarGrilla(this._gestorEventos.ListaEventos);
            }
            else //si no hay ninguna fila selecionada
            {
                MessageBox.Show("Debe selecionar una fila porfavor", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void CerrarVentana(object sender, FormClosedEventArgs e)
        {
            // this._gestorEquipos.Serializar();
            this._gestorEventos.Serializar();
        }

        private void LoadMantEventVentana(object sender, EventArgs e)
        {
            this._gestorEventos.Deserializar();
            this._gestorEquipos.Deserializar();
            CargarGrilla(_gestorEventos.ListaEventos);
        }

        private void CargarGrilla(List<Evento> listaDeEventos)
        {
            this.dataGridView1.Rows.Clear();
            foreach (Evento ev in listaDeEventos)
            {
                string[] row = new string[3];
                row[0] = ev.Nombre;
                row[1] = ev.CategoriaEquipo;
                row[2] = ev.NumEntradas.ToString();
                this.dataGridView1.Rows.Add(row);
            }
        }
    }
}
