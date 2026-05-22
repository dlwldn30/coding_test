class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int n = attacks.length;
        int prev = 0;
        
        int max = health;
        
        for(int i = 0; i < n; i++){
            int time = attacks[i][0];
            int damage = attacks[i][1];
            
            int period = time - prev-1;
            
            health = Math.min(health + period/bandage[0] * bandage[2] + period * bandage[1], max);
            
            health -= damage;
            prev = time;
            
            if(health <= 0) return -1;
            
        }
        
        
        
        return health;
    }
}