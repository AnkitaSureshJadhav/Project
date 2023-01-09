using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace CakeShopS
{
    public partial class Login : Form
    {
        OleDbConnection Connection = new OleDbConnection();
        public Login()
        {
            InitializeComponent();
            Connection.ConnectionString = @"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb";
        }

        private void button1_Click(object sender, EventArgs e)
        {

            Connection.Open();
            OleDbCommand command = new OleDbCommand();
            command.Connection = Connection;
            command.CommandText = "select * from Login where UserName ='" + TxtUser.Text + "'and  Password ='" + TxtPassword.Text + "'";
            OleDbDataReader reader = command.ExecuteReader();
            int count = 0;
            while (reader.Read())
            {
                count = count + 1;
            }
            if (count == 1)
            {
                MessageBox.Show("Login successfully....");
                this.Hide();
                MDI m1 = new MDI();
                m1.ShowDialog();
            }
            else
            {
                MessageBox.Show("UserName or Password is incorrect");
            }
            Connection.Close();

        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            this.Hide();
            MDI m1 = new MDI();
            m1.ShowDialog();
        
        }
    }
}
