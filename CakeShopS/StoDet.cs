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
    public partial class StoDet : Form
    {
        public OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb");
        public StoDet()
        {
            InitializeComponent();
        }

        private void TxtcomboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = " Select * from CakeInfo where Name like '" + TxtcomboBox1.SelectedItem + "'";
            OleDbDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                TxtCakeID.Text = Convert.ToString(dr.GetValue(0));
                TxtFlavour.Text = Convert.ToString(dr.GetValue(2));
                TxtPrice.Text = Convert.ToString(dr.GetValue(3));
            }
            con.Close();
        }

        private void StoDet_Load(object sender, EventArgs e)
        {
            FillGridView();
            con.Open();
            OleDbCommand cmd = con.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = " Select * from CakeInfo ";
            OleDbDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                TxtcomboBox1.Items.Add(dr.GetValue(1));
            }

            con.Close();
        }

        private void BtnNew_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (StocID)from StoDet";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {
                    TxtStockID.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtStockID.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtCakeID.Text = "";
            TxtAvailableQty.Text = "";
            con.Close();
        }

        private void BtnSave_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "insert into StoDet values (" + TxtStockID.Text + "," + TxtCakeID.Text + "," +TxtAvailableQty.Text+")";
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
            cmd.CommandText = "delete from StoDet where StocID  =" + TxtStockID.Text + "";
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
            cmd.CommandText = "Update CakeInfo set CakeID =" + TxtStockID.Text + ",Cake ID =" + TxtCakeID.Text + ", Available Quantity=" + TxtAvailableQty.Text + ")";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Update ...");
            con.Close();
            FillGridView();

        }

        private void Btnsear_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select * from StoDet where StocID=" + TxtStockID.Text + "";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                TxtStockID.Text = rd.GetValue(0).ToString();
                TxtCakeID.Text = rd.GetValue(1).ToString();
                TxtAvailableQty.Text = rd.GetValue(2).ToString();
            }
            con.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            FillGridView();
        }


        void FillGridView()
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select *from StoDet";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(dt);
            dataGridView1.DataSource = dt;
            con.Close();
        }
    
public  string TxtQtyText { get; set; }}
}
            


     




 

        
