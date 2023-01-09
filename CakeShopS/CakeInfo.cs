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
    public partial class CakeInfo : Form
    {
        public OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb");
        public CakeInfo()
        {
            InitializeComponent();
        }

        private void BtnNew_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (CakeID)from CakeInfo";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {
                    TxtCakeid.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtCakeid.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtCakeName.Text = "";
            TxtCakeFlavour.Text = "";
            TxtCakePrice.Text = "";
            con.Close();
        }

        private void BtnSave_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "insert into CakeInfo values(" + TxtCakeid.Text + ",'" + TxtCakeName.Text + "','" + TxtCakeFlavour.Text + "'," + TxtCakePrice.Text + ")";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Saved");
            con.Close();
            FillGridView();
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "delete from CakeInfo where CakeID  =" + TxtCakeid.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data deleted successfully");
            con.Close();
            FillGridView();
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "Update CakeInfo set CakeID =" + TxtCakeid.Text + ",Name ='" + TxtCakeName.Text + "',Flavour='" + TxtCakeFlavour.Text + "',Price='" + TxtCakePrice + "' where CakeID=" + TxtCakeid.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Update ...");
            con.Close();
            FillGridView();

        }

        private void BtnSearch_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select * from CakeInfo where CakeID=" + TxtCakeid.Text + "";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                TxtCakeid.Text = rd.GetValue(0).ToString();
                TxtCakeName.Text = rd.GetValue(1).ToString();
                TxtCakeFlavour.Text = rd.GetValue(2).ToString();
                TxtCakePrice.Text = rd.GetValue(3).ToString();
            }
            con.Close();
        }

        private void CakeInfo_Load(object sender, EventArgs e)
        {
            FillGridView();
        }
        void FillGridView()
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select *from CakeInfo ";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(dt);
            dataGridView1.DataSource = dt;
            con.Close();
        }
    }
}
