import java.util.Random;

public class MyAgent extends Agent
{
    Random r;
    int col, row;

    /**
     * Constructs a new agent, giving it the game and telling it whether it is Red or Yellow.
     * 
     * @param game The game the agent will be playing.
     * @param iAmRed True if the agent is Red, False if the agent is Yellow.
     */
    public MyAgent(Connect4Game game, boolean iAmRed)
    {
        super(game, iAmRed);
        r = new Random();
    }

    /**
     * The move method is run every time it is this agent's turn in the game. You may assume that
     * when move() is called, the game has at least one open slot for a token, and the game has not
     * already been won.
     * 
     * By the end of the move method, the agent should have placed one token into the game at some
     * point.
     * 
     * After the move() method is called, the game engine will check to make sure the move was
     * valid. A move might be invalid if:
     * - No token was place into the game.
     * - More than one token was placed into the game.
     * - A previous token was removed from the game.
     * - The color of a previous token was changed.
     * - There are empty spaces below where the token was placed.
     * 
     * If an invalid move is made, the game engine will announce it and the game will be ended.
     * 
     */
    public void move()
    {
        //do{
        for(int i=0; i < myGame.getColumnCount(); i++)
        {
            for(int j=0; i <myGame.getRowCount(); j++)
            {
               // char[][] board = new char[myGame.getColumnCount()][myGame.getRowCount()];
                /**get slot and check if its reds turn 
                 * check if board is full
                 * check if game has been won???
                 */
                //int columnNumber = this.columnNumber;
                if( myGame.getColumn(i).getSlot(j).getIsRed() && myGame.getColumn(i).getSlot(j).getIsFilled() == false )
                {
            
            /**to make best move i.e. to place the 4th piece to win or stop opponent from winning
             
             */
                    if(iCanWin() >-1  )
                    {
                        myGame.getColumn(col).getSlot(row).addRed();
                    }
                    if(theyCanWin() >-1)
                    {
                        myGame.getColumn(col).getSlot(row).addRed();
                    }
                    
                    /**places a piece next to 2 pieces of the same colour 
                     * column wise
                     */
                   //else  if(myGame.getColumn(i).getSlot(j).getIsRed()==true)
                    //{
                        else if(j+2 < myGame.getRowCount())
                        {
                            if(myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i).getSlot(j+1).getIsRed()==true)
                            {
                                myGame.getColumn(i).getSlot(j+2).addRed();
                            }
                        }
                    //}
                    /**places a piece next to 1 piece of same colour
                     * column wise
                     
                     */
                  //  else if(board[i][j]!= 'B')
                   // {
                        else if(j+1 < myGame.getRowCount())
                        {
                            //if(board[j][i]== board[j+1][i])
                            //{
                             myGame.getColumn(i+1).getSlot(j).addRed();
                           // }
                       // }
                        }
                    /**places a piece next to 2 pieces of the same colour
                     * row wise
                     */
                    //else if(board[i][j]!= 'B')
                   // {
                       else if(i+2 < myGame.getColumnCount())
                        {
                            if(myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i+1).getSlot(j).getIsRed()==true)
                            {
                                myGame.getColumn(i+2).getSlot(j).addRed();
                            }
                        }
                        
                        
                        /**
                         * checks to the left of the placed piece horizontally
                         */
                        else if(i+2 < myGame.getColumnCount())
                        {
                            if(myGame.getColumn(i+1).getSlot(j).getIsRed()==true && myGame.getColumn(i-1).getSlot(j).getIsRed()==true)
                            {
                                myGame.getColumn(i).getSlot(j).addRed();
                            }
                        }
                        
                        
                        
                    //}
                    /**places a piece next to 1 piece of the same colour
                     * row wise
                     */
                  //  else if(board[i][j]!= 'B')
                   // {
                        else if(i+1 < myGame.getColumnCount())
                        {
                        //    if(board[j][i]== board[j][i+1])
                          //  {
                                myGame.getColumn(i).getSlot(j+1).addRed();
                            //}
                         }
                   // }
                    /**places a piece next to 2  pieces of the same colour
                     * diag (1 way)
                     */
                   // else if(board[i][j]!=B)
                    //{
                        else if(i+2<myGame.getColumnCount() && j+2< myGame.getRowCount())
                        {
                            if(myGame.getColumn(i-1).getSlot(j+1).getIsRed()==true && myGame.getColumn(i).getSlot(j).getIsRed()==true)
                            {
                                myGame.getColumn(i-2).getSlot(j+2).addRed();
                            
                            }
                    //}
                        }
                /**places a piece next to 2 pieces of the same colour
                 * diag(other way)
                 */
                //else if(board[i][j]!=B)
                    //{
                       else if(i+2<myGame.getColumnCount() && j+2 < myGame.getRowCount())
                        {
                            if(myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i+1).getSlot(j+1).getIsRed()==true)
                            {
                                myGame.getColumn(i+2).getSlot(j+2).addRed();
                            
                            }
                        }
                //}
                
                /*else if(board[i][j]!=B)
                    {
                        if(i+3<game.getColumnCount() && j+3 < game.getRowCount())
                        {
                        if(board[j][i]==board[j+1][i-1] && board[j][i]== board[j+2][i-1])
                        {
                            getColumn(j+3).getSlot(i-3).addRed();
                            
                    }
                    }
                }*/
                //int columnNumber;
                    else{
                            int columnNumber = randomMove();
                            this.moveOnColumn(columnNumber);
                        }
            
          
        }
        }
    }
    }
//}(while myGame.getColumn(i).getSlot(j).redIsAdded() == true );

/**
 * get true or false when slot is filled with red
 */
/*public boolean redIsAdded()
{
    public boolean value = false;
    if(myGame.getColumn(i).getSlot(j).addRed)
    {
    
        value = true;
    }



}*/





    /**
     * Drops a token into a particular column so that it will fall to the bottom of the column.
     * If the column is already full, nothing will change.
     * 
     * @param columnNumber The column into which to drop the token.
     */
    public void moveOnColumn(int columnNumber)
    {
        int lowestEmptySlotIndex = getLowestEmptyIndex(myGame.getColumn(columnNumber));   // Find the top empty slot in the column
                                                                                                  // If the column is full, lowestEmptySlot will be -1
        if (lowestEmptySlotIndex > -1)  // if the column is not full
        {
            Connect4Slot lowestEmptySlot = myGame.getColumn(columnNumber).getSlot(lowestEmptySlotIndex);  // get the slot in this column at this index
            if (iAmRed) // If the current agent is the Red player...
            {
                lowestEmptySlot.addRed(); // Place a red token into the empty slot
            }
            else // If the current agent is the Yellow player (not the Red player)...
            {
                lowestEmptySlot.addYellow(); // Place a yellow token into the empty slot
            }
        }
    }

    /**
     * Returns the index of the top empty slot in a particular column.
     * 
     * @param column The column to check.
     * @return the index of the top empty slot in a particular column; -1 if the column is already full.
     */
    public int getLowestEmptyIndex(Connect4Column column){
        int lowestEmptySlot = -1;
        for  (int i = 0; i < column.getRowCount(); i++)
        {
            if (!column.getSlot(i).getIsFilled())
            {
                lowestEmptySlot = i;
            }
        }
        return lowestEmptySlot;
    }

    /**
     * Returns a random valid move. If your agent doesn't know what to do, making a random move
     * can allow the game to go on anyway.
     * 
     * @return a random valid move.
     */
    public int randomMove()
    {
        int i = r.nextInt(myGame.getColumnCount());
        while (getLowestEmptyIndex(myGame.getColumn(i)) == -1)
        {
            i = r.nextInt(myGame.getColumnCount());
        }
        return i;
    }

    /**
     * Returns the column that would allow the agent to win.
     * 
     * You might want your agent to check to see if it has a winning move available to it so that
     * it can go ahead and make that move. Implement this method to return what column would
     * allow the agent to win.
     *
     * @return the column that would allow the agent to win.
     */
    public int iCanWin()
    {
       // char[][] board = game.getBoardMatrix();
        
        for (int i = 0; i < myGame.getColumnCount(); i++)
        {
            for (int j = 0; j < myGame.getRowCount(); j++)
            {
                if(myGame.getColumn(i).getSlot(j).getIsRed()==true)
                {
                    if (i + 3 < myGame.getColumnCount())
                    {
                        if(myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i+1).getSlot(j).getIsRed()==true && myGame.getColumn(i+2).getSlot(j).getIsRed()==true )
                        {
                           /* highlightSlot(j, i);
                            highlightSlot(j + 1, i);
                            highlightSlot(j + 2, i);
                            highlightSlot(j + 3, i);*/
                           col = i+3;
                           row = j;
                            return col ;
                        }
                    }
                    if (j + 3 < myGame.getRowCount())
                    {
                        if (myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i).getSlot(j+1).getIsRed()==true && myGame.getColumn(i).getSlot(j+2).getIsRed()==true )
                        {
                            /*highlightSlot(j, i);
                            highlightSlot(j, i + 1);
                            highlightSlot(j, i + 2);
                            highlightSlot(j, i + 3);*/
                            col= i;
                            row=j+3;
                            return col ;
                        }
                    }
                    if (i + 3 < myGame.getColumnCount() && j + 3 < myGame.getRowCount())
                    {
                        if(myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i+1).getSlot(j+1).getIsRed()==true && myGame.getColumn(i+2).getSlot(j+2).getIsRed()==true )
                        {
                           /* highlightSlot(j, i);
                            highlightSlot(j + 1, i + 1);
                            highlightSlot(j + 2, i + 2);
                            highlightSlot(j + 3,i + 3);*/
                            col=i+3;
                            row=j+3;
                            return col ;
                        }
                    }
                    if (i > 2 && j + 3 < myGame.getRowCount())
                    {
                        if (myGame.getColumn(i).getSlot(j).getIsRed()==true && myGame.getColumn(i).getSlot(j-1).getIsRed()==true && myGame.getColumn(i).getSlot(j-2).getIsRed()==true )
                        {
                            /*highlightSlot(j, i);
                            highlightSlot(j + 1, i - 1);
                            highlightSlot(j + 2, i - 2);
                            highlightSlot(j + 3, i - 3);*/
                            col= i+3;
                            row= j-3;
                            return col ;
                        }
                    }
                }
            }
        }

        //return 'N';
        
        
        
        return 0;
    }

    /**
     * Returns the column that would allow the opponent to win.
     * 
     * You might want your agent to check to see if the opponent would have any winning moves
     * available so your agent can block them. Implement this method to return what column should
     * be blocked to prevent the opponent from winning.
     *
     * @return the column that would allow the opponent to win.
     */
    public int theyCanWin()
    {
        //char[][] board = game.getBoardMatrix();
        
        for (int i = 0; i < myGame.getColumnCount(); i++)
        {
            for (int j = 0; j < myGame.getRowCount(); j++)
            {
                if(myGame.getColumn(i).getSlot(j).getIsRed()==false && myGame.getColumn(i).getSlot(j).getIsFilled()==false)
                {
                    /**
                     * checks best move column wise
                     */
                    if (i+ 3 < myGame.getColumnCount())
                    {
                        if(myGame.getColumn(i).getSlot(j).getIsRed()==false && myGame.getColumn(i+1).getSlot(j).getIsRed()==false && myGame.getColumn(i+2).getSlot(j).getIsRed()==false && myGame.getColumn(i).getSlot(j).getIsFilled()==false && myGame.getColumn(i+1).getSlot(j).getIsFilled()==false && myGame.getColumn(i+2).getSlot(j).getIsFilled()==false  )
                        {
                           /* highlightSlot(j, i);
                            highlightSlot(j + 1, i);
                            highlightSlot(j + 2, i);
                            highlightSlot(j + 3, i);*/
                            col= i+3;
                            row=j;
                            return col;
                        }
                    }
                    /**
                     * checks best move row wise
                     */
                    if (j + 3 < myGame.getRowCount())
                    {
                        if (myGame.getColumn(i).getSlot(j).getIsRed()==false && myGame.getColumn(i).getSlot(j+1).getIsRed()==false && myGame.getColumn(i).getSlot(j+2).getIsRed()==false && myGame.getColumn(i).getSlot(j).getIsFilled()==false && myGame.getColumn(i).getSlot(j+1).getIsFilled()==false && myGame.getColumn(i).getSlot(j+2).getIsFilled()==false )
                        {
                            /*highlightSlot(j, i);
                            highlightSlot(j, i + 1);
                            highlightSlot(j, i + 2);
                            highlightSlot(j, i + 3);*/
                            col= i;
                            row= j+3;
                            return col;
                        }
                    }
                    /**
                     * checks best move diag one way
                     */
                    if (i + 3 < myGame.getColumnCount() && j + 3 < myGame.getRowCount())
                    {
                        if(myGame.getColumn(i).getSlot(j).getIsRed()==false && myGame.getColumn(i+1).getSlot(j+1).getIsRed()==false && myGame.getColumn(i+2).getSlot(j+2).getIsRed()==false && myGame.getColumn(i).getSlot(j).getIsFilled()==false && myGame.getColumn(i+1).getSlot(j+1).getIsFilled()==false && myGame.getColumn(i+2).getSlot(j+2).getIsFilled()==false  )
                        {
                           /* highlightSlot(j, i);
                            highlightSlot(j + 1, i + 1);
                            highlightSlot(j + 2, i + 2);
                            highlightSlot(j + 3,i + 3);*/
                            col=i+3;
                            row= j+3;
                            return col;
                        }
                    }
                    /**
                     * checks best move diag other way
                     */
                    if (i > 2 && j + 3 < myGame.getRowCount())
                    {
                        if (myGame.getColumn(i).getSlot(j).getIsRed()==false && myGame.getColumn(i+1).getSlot(j-1).getIsRed()==false && myGame.getColumn(i+2).getSlot(j-2).getIsRed()==false && myGame.getColumn(i).getSlot(j).getIsFilled()==false && myGame.getColumn(i+1).getSlot(j-1).getIsFilled()==false && myGame.getColumn(i+2).getSlot(j-2).getIsFilled()==false  )
                        {
                            /*highlightSlot(j, i);
                            highlightSlot(j + 1, i - 1);
                            highlightSlot(j + 2, i - 2);
                            highlightSlot(j + 3, i - 3);*/
                            col= i+3;
                            row= j-3;
                            return col;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Returns the name of this agent.
     *
     * @return the agent's name
     */
    public String getName()
    {
        return "My Agent";
    }
}
