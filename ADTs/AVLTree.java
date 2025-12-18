import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArbolAVL objeto=new ArbolAVL();
        objeto.m_instertar(10);
        objeto.m_instertar(5);
        objeto.m_instertar(13);
        objeto.m_instertar(1);
        objeto.m_instertar(6);
        objeto.m_instertar(17);
        objeto.m_instertar(16);
        objeto.m_mostPreOrden(objeto.m_obtenerRaiz());
    }
}
class NodoArbolAVL{
    int a_dato,a_FE;
    NodoArbolAVL a_izquierda,a_derecha;
    NodoArbolAVL(int p_dato){
        a_dato=p_dato;
        a_FE=0;
        a_izquierda=a_derecha=null;
    }
}
class ArbolAVL{
    NodoArbolAVL a_raiz;
    ArbolAVL(){
        a_raiz=null;
    }
    NodoArbolAVL m_obtenerRaiz(){
        return a_raiz;
    }
    NodoArbolAVL m_buscar(int p_dato,NodoArbolAVL p_nodo){
        if(a_raiz==null) return null;
        else if(p_nodo.a_dato==p_dato) return p_nodo;
        else if(p_nodo.a_dato<p_dato) return m_buscar(p_dato,p_nodo.a_derecha);
        else return m_buscar(p_dato,p_nodo.a_izquierda);
    }
    int m_obtenerFE(NodoArbolAVL p_nodox){
        if(p_nodox==null) return -1;
        else return p_nodox.a_FE;
    }
    NodoArbolAVL m_rotacionIzquierda(NodoArbolAVL p_nodo){
        NodoArbolAVL v_auxiliar=p_nodo.a_izquierda;
        p_nodo.a_izquierda=v_auxiliar.a_derecha;
        v_auxiliar.a_derecha=p_nodo;
        p_nodo.a_FE=Math.max(m_obtenerFE(p_nodo.a_izquierda),m_obtenerFE(p_nodo.a_derecha))+1;
        v_auxiliar.a_FE=Math.max(m_obtenerFE(v_auxiliar.a_izquierda),m_obtenerFE(v_auxiliar.a_derecha))+1;
        return v_auxiliar;
    }
    NodoArbolAVL m_rotacionDerecha(NodoArbolAVL p_nodo){
        NodoArbolAVL v_auxiliar=p_nodo.a_derecha;
        p_nodo.a_derecha=v_auxiliar.a_izquierda;
        v_auxiliar.a_izquierda=p_nodo;
        p_nodo.a_FE=Math.max(m_obtenerFE(p_nodo.a_izquierda),m_obtenerFE(p_nodo.a_derecha))+1;
        v_auxiliar.a_FE=Math.max(m_obtenerFE(v_auxiliar.a_izquierda),m_obtenerFE(v_auxiliar.a_derecha))+1;
        return v_auxiliar;
    }
    NodoArbolAVL m_rotacionDobleIzquierda(NodoArbolAVL p_nodo){
        NodoArbolAVL v_temporal;
        p_nodo.a_izquierda=m_rotacionDerecha(p_nodo.a_izquierda);
        v_temporal=m_rotacionIzquierda(p_nodo);
        return v_temporal;
    }
    NodoArbolAVL m_rotacionDobleDerecha(NodoArbolAVL p_nodo){
        NodoArbolAVL v_temporal;
        p_nodo.a_derecha=m_rotacionIzquierda(p_nodo.a_derecha);
        v_temporal=m_rotacionDerecha(p_nodo);
        return v_temporal;
    }
    NodoArbolAVL m_insertarAVL(NodoArbolAVL p_nuevo,NodoArbolAVL p_subAr){
        NodoArbolAVL v_nuevoPadre=p_subAr;
        if(p_nuevo.a_dato<p_subAr.a_dato){
            if(p_subAr.a_izquierda==null){
                p_subAr.a_izquierda=p_nuevo;
            }else{
                p_subAr.a_izquierda=m_insertarAVL(p_nuevo,p_subAr.a_izquierda);
                if((m_obtenerFE(p_subAr.a_izquierda) - m_obtenerFE(p_subAr.a_derecha)==2)){
                    if(p_nuevo.a_dato<p_subAr.a_izquierda.a_dato){
                        v_nuevoPadre=m_rotacionIzquierda(p_subAr);
                    }else{
                        v_nuevoPadre=m_rotacionDobleIzquierda(p_subAr);
                    }
                }
            }
        }else if(p_nuevo.a_dato>p_subAr.a_dato){
            if(p_subAr.a_derecha==null){
                p_subAr.a_derecha=p_nuevo;
            }else{
                p_subAr.a_derecha=m_insertarAVL(p_nuevo,p_subAr.a_derecha);
                if((m_obtenerFE(p_subAr.a_derecha) - m_obtenerFE(p_subAr.a_izquierda)==2)){
                    if(p_nuevo.a_dato>p_subAr.a_derecha.a_dato){
                        v_nuevoPadre=m_rotacionDerecha(p_subAr);
                    }else{
                        v_nuevoPadre=m_rotacionDobleDerecha(p_subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        if((p_subAr.a_izquierda==null) && (p_subAr.a_derecha!=null)){
            p_subAr.a_FE=p_subAr.a_derecha.a_FE+1;
        }else if((p_subAr.a_derecha==null) && (p_subAr.a_izquierda!=null)){
            p_subAr.a_FE=p_subAr.a_izquierda.a_FE+1;
        }else{
            p_subAr.a_FE=Math.max(m_obtenerFE(p_subAr.a_izquierda),m_obtenerFE(p_subAr.a_derecha))+1;
        }
        return v_nuevoPadre;
    }
    void m_instertar(int p_dato){
        NodoArbolAVL v_nuevo=new NodoArbolAVL(p_dato);
        if(a_raiz==null){
            a_raiz=v_nuevo;
        }else{
            a_raiz=m_insertarAVL(v_nuevo,a_raiz);
        }
    }
    void m_mostInOrden(NodoArbolAVL p_raiz){
        if(p_raiz!=null){
            m_mostInOrden(p_raiz.a_izquierda);
            System.out.println(p_raiz.a_dato);
            m_mostInOrden(p_raiz.a_derecha);
        }
    }
    void m_mostPreOrden(NodoArbolAVL p_raiz){
        if(p_raiz!=null){
            System.out.println(p_raiz.a_dato);
            m_mostPreOrden(p_raiz.a_izquierda);
            m_mostPreOrden(p_raiz.a_derecha);
        }
    }
    void m_mostPostOrden(NodoArbolAVL p_raiz){
        if(p_raiz!=null){
            m_mostPostOrden(p_raiz.a_izquierda);
            m_mostPostOrden(p_raiz.a_derecha);
            System.out.println(p_raiz.a_dato);
        }
    }
    
}