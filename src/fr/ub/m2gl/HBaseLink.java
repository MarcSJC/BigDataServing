package fr.ub.m2gl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class HBaseLink {

	public static class HBaseProg extends Configured implements Tool {
		private static TableName TABLE_NAME = TableName.valueOf("PascalTestTiles2");

		public byte[] get(int z, int x, int y) throws IOException {
			Connection connection = ConnectionFactory.createConnection(getConf());
			Table table = connection.getTable(TABLE_NAME);
			String row = z + "/" + x + "/" + y;
			Get g = new Get(row.getBytes());
			Result r = table.get(g);
			byte[] value = r.getValue("File".getBytes(), "Tile".getBytes());
			return value;
		}
		
		public int run(String[] args) throws IOException {
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(HBaseConfiguration.create(), new HBaseLink.HBaseProg(), args);
		System.exit(exitCode);
	}
}


