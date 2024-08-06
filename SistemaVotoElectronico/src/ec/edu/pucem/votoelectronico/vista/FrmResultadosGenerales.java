package ec.edu.pucem.votoelectronico.vista;

import javax.swing.*;
import ec.edu.pucem.votoelectronico.controlador.SufragioController;
import ec.edu.pucem.votoelectronico.modelo.Candidato;
import ec.edu.pucem.votoelectronico.modelo.Voto;

import java.awt.*;
import java.util.List;

public class FrmResultadosGenerales extends JFrame {
    private static final long serialVersionUID = 1L;

    public FrmResultadosGenerales(SufragioController controller) {
        setTitle("Resultados Generales");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Candidato> candidatos = controller.getCandidatos();
        int[] values = new int[candidatos.size()];
        String[] labels = new String[candidatos.size()];
        Color[] colors = new Color[candidatos.size()]; 

        Color[] presetColors = {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE}; 
        for (int i = 0; i < candidatos.size(); i++) {
            colors[i] = presetColors[i % presetColors.length]; 
        }

        List<Voto> votos = controller.obtenerVotos();

        for (int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);
            values[i] = (int) votos.stream()
                                   .filter(voto -> voto.getCandidato().equals(candidato))
                                   .count();
            labels[i] = candidato.getNombre();
        }

        BarraResultados barraResultados = new BarraResultados(values, labels, colors); 
        add(barraResultados, BorderLayout.CENTER);
    }
}
