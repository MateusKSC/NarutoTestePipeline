package com.projetonaruto.enuns;

public enum CategoriaJutsuEnum {
    NINJANINJUTSU,
    NINJAGENJUTSU,
    NINJATAIJUTSU,
    ;

    public static boolean contains(String palavra){
        for(CategoriaJutsuEnum e : CategoriaJutsuEnum.values()){
            if(e.name().equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }

}