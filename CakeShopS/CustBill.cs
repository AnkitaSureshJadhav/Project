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
    public partial class CustBill : Form
    {
        public OleDbConnection con = new OleDbConnection(@"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=D:\cake project\CakeShopS\Database21.accdb");
        public CustBill()
        {
            InitializeComponent();
        }

        private void CustBill_Load(object sender, EventArgs e)
        {
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

        private void TxtQty_TextChanged(object sender, EventArgs e)
        {
            if (TxtQty.Text.Length > 0)
            {
                TxtTotal.Text = (Convert.ToInt16(TxtPrice.Text) * Convert.ToInt16(TxtQty.Text)).ToString();
            }
        }
  

        private void btnNew_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (ID)from CustBill";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {

                    TxtBillID.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtBillID.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtBillID.Text = "";
            TxtCakeID.Text = "";
            TxtQty.Text = "";
            TxtTotal.Text = "";


            con.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            con.Open();
            int Max1;
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = " select max (CustBID)from CustBill";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                if (Convert.IsDBNull(rd[0].ToString()))
                {

                    TxtCBNo.Text = Convert.ToString(1);

                }
                else
                {
                    Max1 = Convert.ToInt32(rd[0].ToString()) + 1;
                    TxtCBNo.Text = Convert.ToString(Max1);
                }
            }


            rd.Close();
            TxtCBNo.Text = "";
            TxtBillID.Text = "";
            TxtCakeID.Text = "";
            TxtQty.Text = "";
            TxtTotal.Text = "";

            con.Close();
            con.Open();


            cmd.Connection = con;
            cmd.CommandText = "insert into CustBillCake values(" + TxtCBNo.Text + " ,"+ TxtBillID.Text + "," + TxtCakeID.Text + "," + TxtQty.Text + "," + TxtTotal.Text + ")";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Save....");
            con.Close();
            FillGridView();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "delete from CustBill where ID  =" + TxtBillID.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data deleted successfully");
            con.Close();
            FillGridView();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "Update CustBill set ID =" + TxtBillID.Text + ",Cake ID =" + TxtCakeID.Text + ",Quantity=" + TxtQty.Text + ",Total=" + TxtTotal + " where ID=" + TxtBillID.Text + "";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Update ...");
            con.Close();
            FillGridView();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select * from CustBill where ID=" + TxtBillID.Text + "";
            OleDbDataReader rd = cmd.ExecuteReader();
            while (rd.Read())
            {
                TxtBillID.Text = rd.GetValue(0).ToString();
                TxtCakeID.Text = rd.GetValue(1).ToString();
                TxtTotal.Text = rd.GetValue(3).ToString();

            }
            con.Close();
        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
                  FillGridView();
        }

        
        void FillGridView()
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "select *from CustBill";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(dt);
            dataGridView2.DataSource = dt;
            con.Close();
        
        }


        private void BtnSave_Click_1(object sender, EventArgs e)
        {
            con.Open();
            OleDbCommand cmd = new OleDbCommand();
            cmd.Connection = con;
            cmd.CommandText = "insert into CustBillCake values(" + TxtCBNo.Text + " ," + TxtBillID.Text + "," + TxtCakeID.Text + "," + TxtQty.Text + "," + TxtTotal.Text + ")";
            cmd.ExecuteNonQuery();
            MessageBox.Show("Data Save....");
            con.Close();
            FillGridView();
        }

    }
}