class Solution {
    
    public boolean isLongPressedName(String name, String typed, int n, int m, int nameIndex, int typedIndex) {
        
        if(typedIndex == m){
            return (nameIndex == n);
        }
        
        if(nameIndex < n && name.charAt(nameIndex) != typed.charAt(typedIndex)) return false;
        
        
        int endIndexName = nameIndex;
        while(endIndexName + 1 < n && name.charAt(endIndexName + 1) == name.charAt(nameIndex)){
            endIndexName++;
        }
        
        int endIndexType = typedIndex;
        while(endIndexType + 1 < m && typed.charAt(endIndexType + 1) == typed.charAt(typedIndex)){
            endIndexType++;
        }
        
        if(endIndexName - nameIndex > endIndexType - typedIndex){
            return false;
        }
        
        return isLongPressedName(name, typed, n, m, endIndexName + 1, endIndexType + 1) ;
    }
    
    
    public boolean isLongPressedName(String name, String typed) {
        
        int n = name.length();
        int m = typed.length();
        return isLongPressedName(name, typed, n, m, 0, 0);
    }
}

/**

"alex"
"aaleex"
"saeed"
"ssaaedd"
"alex"
"aaleexababba"
"alex"
"aaleexa"
"vtkgn"
"vttkgnn"
"alex"
"aaleelx"
*/