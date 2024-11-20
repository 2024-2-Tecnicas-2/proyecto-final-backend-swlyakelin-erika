package com.proyecto.SWL.Controlador;
import com.proyecto.SWL.DTO.ProductosDTO;
import com.proyecto.SWL.Servicio.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Productos")
public class ProductosControlador {

    @Autowired
    private ProductosServicio productosServicio;

    @GetMapping("/productos")
    public String productos (Model model){
        List<ProductosDTO> productos = productosServicio.visualizarProductos();
        model.addAttribute("VisProductos", productos);
        return "Admin/Productos/productos";
    }

    @GetMapping("/NuevoProducto") //Visualizar formulario
    public String nuevosproductos (Model model) {
        ProductosDTO productosDTO = new ProductosDTO();
        model.addAttribute("productosVis", productosDTO);
        return "Admin/Productos/NuevoProducto";
    }

    @PostMapping("/DatosNuevosProductos")
    public String datosNuevos(@ModelAttribute("productosVis") ProductosDTO productosDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Productos/NuevoProducto?Error";
        }
        productosServicio.GuardarNuevoProducto(productosDTO);
        return "redirect:/Productos/productos?CorrectoProductos";
    }

    @GetMapping("/EditarProductos/{id}")
    public String editarProductos(@PathVariable("id")Long id, Model model){
        ProductosDTO productosDTO = productosServicio.ObtenerProductosId(id);
        model.addAttribute("editarProductos",productosDTO);
        return "Admin/Productos/EditarProductos";
    }

    @PostMapping("/EditarProductoFinal")
    public String EditarProductosFinal(@ModelAttribute("editarProductos")ProductosDTO productosDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/Productos/EditarProductos?ErrorProductos";
        }if (productosDTO.getIdProductos()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        productosServicio.EditarProductos(productosDTO);
        return "redirect:/Productos/productos?EditarProductoCorrecto";
    }

}
