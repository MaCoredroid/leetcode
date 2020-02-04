class DpValue{
    public LinkedList<int[]> value;
    public DpValue()
    {
        this.value=new LinkedList<int[]>();
    }
}


class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        DpValue[] dp=new DpValue[dungeon[0].length];
        for(int i=0;i<dp.length;i++)
		{
			dp[i]=new DpValue();
		}
       
        int[] first={0,0};
        dp[0].value.add(first);
        
        for(int i=0;i<dungeon.length;i++)
        {
            for(int j=0;j<dungeon[0].length;j++)
            {
                if(j!=0)
                { 
                    for(int[] temp:dp[j-1].value)
                    {
                        int[] newcopy={temp[0],temp[1]};
                        dp[j].value.add(newcopy);
                    }
                }
                int minloss=Integer.MAX_VALUE;
                for(int[] temp:dp[j].value)
                {
                    if(dungeon[i][j]>0)
                    {
                        temp[0]+=dungeon[i][j];
                    }
                    else
                    {
                        if(temp[0]+dungeon[i][j]>=0)
                        {
                            temp[0]+=dungeon[i][j];
                        }
                        else
                        {
                            temp[1]-=dungeon[i][j]+temp[0];
                            temp[0]=0;
                        }
                    }
                    if( temp[1]<minloss)
                    {
                        minloss=temp[1];
                    }
                }
                LinkedList<int[]> templist1=new LinkedList<int[]>(dp[j].value);
                for(int[] temp:templist1)
                {
                    if(temp[1]-temp[0]>minloss)
                    {
                        dp[j].value.remove(temp);
                    }
                }

            }
        }
        int ansLoss=Integer.MAX_VALUE;
        for(int[] temp:dp[dungeon[0].length-1].value)
        {
            ansLoss=Math.min(temp[1],ansLoss);
        }
        return ansLoss+1;
    }
}