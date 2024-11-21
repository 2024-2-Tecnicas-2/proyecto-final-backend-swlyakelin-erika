package com.proyecto.SWL.Servicio;


import com.proyecto.SWL.DTO.ComprasDTO;
import com.proyecto.SWL.Modelo.Compras;
import com.proyecto.SWL.Repositorio.ICompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComprasServicio {

    @Autowired
    private ICompras iCompras;

    private ComprasDTO estadosDTO(Compras compras){
        ComprasDTO comprasDTO = new ComprasDTO();
        comprasDTO.setIdVenta(compras.getIdVenta());
        comprasDTO.setFechaVenta(compras.getFechaVenta());
        comprasDTO.setMonto(compras.getMonto());
        return comprasDTO;
    }
    public List<ComprasDTO> visualizarVenta(){
        List<Compras> compras = iCompras.findAll();
        return compras.stream().map(this::estadosDTO).collect(Collectors.toList());
    }
    public void GuardarNuevaCompra(ComprasDTO comprasDTO){
        Compras c = new Compras();
        c.setIdVenta(comprasDTO.getIdVenta());
        c.setFechaVenta(comprasDTO.getFechaVenta());
        c.setMonto(comprasDTO.getMonto());
        iCompras.save(c);
    }
    public ComprasDTO ObtenerCompraId(Long id){
        Compras e = iCompras.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro la compra"));
        ComprasDTO comprasDTO = estadosDTO(e);
        return comprasDTO;
    }
    public void EditarCompra(ComprasDTO comprasDTO){
        Compras c = iCompras.findById(comprasDTO.getIdVenta())
                .orElseThrow(()->new RuntimeException("No se encontro la compra"));
        c.setIdVenta(comprasDTO.getIdVenta());
        c.setFechaVenta(comprasDTO.getFechaVenta());
        c.setMonto(comprasDTO.getMonto());
        iCompras.save(c);
    }
}