package com.proyecto.SWL.Servicio;


import com.proyecto.SWL.DTO.ProductosDTO;
import com.proyecto.SWL.Modelo.Productos;
import com.proyecto.SWL.Repositorio.IProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServicio {

    @Autowired
    private IProductos iProductos;

    private ProductosDTO productosDTO(Productos productos){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setIdProductos(productos.getIdProducto());
        productosDTO.setNombre(productos.getNombre());
        productosDTO.setPrecio(productos.getPrecio());
        productosDTO.setCategoria(productos.getCategoria());

        return productosDTO;
    }

    public List<ProductosDTO> visualizarProductos(){
        List<Productos> productos = iProductos.findAll();
        return productos.stream().map(this::productosDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoProducto(ProductosDTO productosDTO){
        Productos p = new Productos();
        p.setNombre(productosDTO.getNombre());
        p.setPrecio(productosDTO.getPrecio());
        p.setCategoria(productosDTO.getCategoria());

        iProductos.save(p);
    }

    public ProductosDTO ObtenerProductosId(Long id){
        Productos p = iProductos.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el producto"));
        ProductosDTO productosDTO = productosDTO(p);
        return productosDTO;
    }


    public void EditarProductos(ProductosDTO productosDTO){
        Productos p = iProductos.findById(productosDTO.getIdProductos())
                .orElseThrow(()->new RuntimeException("No se encontro el producto"));
        p.setNombre(productosDTO.getNombre());
        p.setPrecio(productosDTO.getPrecio());
        p.setCategoria(productosDTO.getCategoria());

        iProductos.save(p);
    }
}
