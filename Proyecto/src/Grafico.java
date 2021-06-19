
import java.util.Vector;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico extends JFrame {
	

	public Grafico(Vector<Integer> v, String name) {
		
        XYSeries series = new XYSeries(name);

        for(int i=0;i<v.size();i++) {
        	series.add(Double.valueOf(i),Double.valueOf(v.get(i)));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", // Título
                "Tiempo", // Etiqueta Coordenada X
                "Cotizacion", // Etiqueta Coordenada Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Muestra la leyenda de los productos (Producto A)
                true,
                true
        );
		
		ChartPanel contenedor = new ChartPanel(chart);
		
		this.add(contenedor);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

}
