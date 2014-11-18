package universe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.beans.Transient;

import javax.swing.JPanel;

public class GameOfLifeGui extends JPanel {

	private static final long serialVersionUID = 1L;
	final Color aLiveCell = Color.BLACK;
	final Color deadCell = Color.WHITE;
	final Cells cells;
	final int cellWitdth = 10;
	final int cellHeight = 10;

	Cell minCell;
	Cell maxCell;

	GameOfLifeGui(Cells cells) {
		this.cells = cells;
		refreshMinMax();
	}

	private void refreshMinMax() {
		minCell = cells.getMin();
		maxCell = cells.getMax();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Color gColor = g2.getColor();
		refreshMinMax();
		for (int row = minCell.x; row <= maxCell.x; row++) {
			for (int col = minCell.y; col <= maxCell.y; col++) {
				Cell toTest = new Cell(row, col);
				if (cells.contains(toTest)) {
					g2.setColor(aLiveCell);
					Rectangle rect = new Rectangle(col * cellWitdth, row
							* cellHeight, cellWitdth, cellHeight);
					g2.fill(rect);
				}
			}
		}
		g2.setColor(gColor);
	}

	@Override
	@Transient
	public Dimension getPreferredSize() {
		refreshMinMax();
		int width = maxCell.y - minCell.y;
		int heigth = maxCell.x - minCell.x;
		return new Dimension(width * cellWitdth, heigth * cellHeight);
	}
}
