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

/*
 * Nombre: Diego Pavel Vargas Flores
 * Examen 1
 */

namespace EQuipu.Vista
{
    public partial class frmNuevaFeria : Form
    {
        private GestorFeria _gestorFeria;
        private List<Equipo> _equipos;

        public frmNuevaFeria()
        {
            InitializeComponent();
            _gestorFeria = new GestorFeria();
            _equipos = new List<Equipo>();
            ColocarNombres();
        }

        private void addBtn_Click(object sender, EventArgs e)
        {
            if (_equipos.Count != 8)
            {
                MessageBox.Show("No pueden haber stands vacios");
            }
            else
            {
                string nombre = this.nombreBox.Text;
                DateTime fecha = this.timeBoxPicker.Value;
                Feria feria = new Feria(nombre, fecha);

                for (int i = 0; i < _equipos.Count; i++ )
                {
                    feria.AddEquipo(_equipos[i], i);
                }

                _gestorFeria.AgregarFeria(feria);
                this._gestorFeria.Serializar();
                MessageBox.Show("Agregado!");
                this.Close();
            }
        }

        private void asignarEquipo(object sender, EventArgs e)
        {
            /*
             * Primero se sacaría el valor Tag asignado al Panel, y con eso llamar a la ventana
             * NuevaFeria para que sepa dónde colocar el equipo. Peeeero, con List<> no se puede
             * lograr esto. Así que agrega por orden...
             */
            // System.Windows.Forms.Panel aux = (System.Windows.Forms.Panel)sender;
            // frmNewFairAddTeam ventanaNuevaFeria = new frmNewFairAddTeam(_equipos, Convert.ToInt16(aux.Tag));
            frmNewFairAddTeam ventanaNuevaFeria = new frmNewFairAddTeam(_equipos, _equipos.Count);
            ventanaNuevaFeria.ShowDialog();
            ColocarNombres();
        }

        private void cancelBtn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void ColocarNombres()
        {
            this.stand1Label.Text = obtenerNombreEquipo(0);
            this.stand2Label.Text = obtenerNombreEquipo(1);
            this.stand3Label.Text = obtenerNombreEquipo(2);
            this.stand4Label.Text = obtenerNombreEquipo(3);
            this.stand5Label.Text = obtenerNombreEquipo(4);
            this.stand6Label.Text = obtenerNombreEquipo(5);
            this.stand7Label.Text = obtenerNombreEquipo(6);
            this.stand8Label.Text = obtenerNombreEquipo(7);
        }

        private string obtenerNombreEquipo(int idx)
        {
            if (_equipos.Count <= idx)
            {
                return "[Sin Asignar]";
            }
            else
            {
                if (_equipos[idx] != null)
                    return _equipos.ElementAt(idx).Nombre;
                else
                    return "[Sin Asignar]";
            }
        }
    }
}
