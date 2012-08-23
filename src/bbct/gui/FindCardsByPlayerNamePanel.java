/*
 * This file is part of BBCT.
 *
 * Copyright 2012 codeguru <codeguru@users.sourceforge.net>
 *
 * BBCT is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BBCT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bbct.gui;

import bbct.data.BaseballCard;
import bbct.data.BaseballCardIO;
import bbct.exceptions.IOException;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * TODO: JavaDoc
 *
 * TODO: Tweak component placement and size
 *
 * TODO: Update instructions as user interacts with interface
 *
 * @author codeguru <codeguru@users.sourceforge.net>
 */
public class FindCardsByPlayerNamePanel extends FindCardsByPanel {

    /**
     * Creates new {@link FindCardsByPlayerNamePanel}.
     * @param bcio 
     */
    public FindCardsByPlayerNamePanel(BaseballCardIO bcio) {
        this.bcio = bcio;
        initComponents();
    }

    @Override
    protected List<BaseballCard> getBaseballCards() throws IOException {
        String playerName = this.playerNameTextField.getText();
        
        return this.bcio.getBaseballCardsByPlayerName(playerName);
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout());
        
        JLabel playerNameLabel = new JLabel("Player Name:");
        playerNameLabel.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        this.add(playerNameLabel);
        
        this.playerNameTextField = new JTextField();
        this.playerNameTextField.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        this.playerNameTextField.setColumns(10);
        this.add(this.playerNameTextField);
    }
    
    private JTextField playerNameTextField;
    private BaseballCardIO bcio = null;
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("FindCardsByNumberPanel Test");
        frame.add(new FindCardsByPlayerNamePanel(null));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}