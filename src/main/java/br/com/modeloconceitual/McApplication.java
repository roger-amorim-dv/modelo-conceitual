package br.com.modeloconceitual;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.modeloconceitual.domain.Categoria;
import br.com.modeloconceitual.domain.Cidade;
import br.com.modeloconceitual.domain.Cliente;
import br.com.modeloconceitual.domain.Endereco;
import br.com.modeloconceitual.domain.Estado;
import br.com.modeloconceitual.domain.Pagamento;
import br.com.modeloconceitual.domain.PagamentoComBoleto;
import br.com.modeloconceitual.domain.PagamentoComCartao;
import br.com.modeloconceitual.domain.Pedido;
import br.com.modeloconceitual.domain.Produto;
import br.com.modeloconceitual.domain.enums.EstadoPagamento;
import br.com.modeloconceitual.domain.enums.TipoCliente;
import br.com.modeloconceitual.repositories.CategoriaRepository;
import br.com.modeloconceitual.repositories.CidadeRepository;
import br.com.modeloconceitual.repositories.ClienteRepository;
import br.com.modeloconceitual.repositories.EnderecoRepository;
import br.com.modeloconceitual.repositories.EstadoRepository;
import br.com.modeloconceitual.repositories.PagamentoRepository;
import br.com.modeloconceitual.repositories.PedidoRepository;
import br.com.modeloconceitual.repositories.ProdutoRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat01 = new Categoria(null, "Informática");
		Categoria cat02 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat01.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat02.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat01));
		p2.getCategorias().addAll(Arrays.asList(cat01, cat02));
		p3.getCategorias().addAll(Arrays.asList(cat01));
		
		Estado est01 = new Estado(null, "Minas Gerais");
		Estado est02 = new Estado(null, "São Paulo");
		
		Cidade c01 = new Cidade(null, "Uberlândia", est01);
		Cidade c02 = new Cidade(null, "São Paulo", est02);
		Cidade c03 = new Cidade(null, "Campinas", est02);
		
		est01.getCidades().addAll(Arrays.asList(c01));
		est02.getCidades().addAll(Arrays.asList(c02, c03));
		
		Cliente cli01 = new Cliente(null, "Maria Silva", "maria@gmail.com", "11122233344", TipoCliente.PESSOAFISICA);
		
		cli01.getTelefones().addAll(Arrays.asList("987769844", "943122876"));
		
		Endereco e01 = new Endereco(null, "Rua Flores", "300", "APTO 303", "Jardim", "07247223", cli01, c01);
		Endereco e02 = new Endereco(null, "Rua Rosas", "400", "APTO 302", "Jardim", "07247223", cli01, c02);
		
		cli01.getEnderecos().addAll(Arrays.asList(e01, e02));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped01 = new Pedido(null, sdf.parse("30/09/2017 10:32"), null,  cli01, e01);
		Pedido ped02 = new Pedido(null, sdf.parse("10/10/2017 11:40"), null, cli01, e02);
		
		Pagamento pagto01 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped01, 6);
		ped01.setPagamento(pagto01);
		
		Pagamento pagto02 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped02, sdf.parse("20/10/2017 00:00"), null);
		ped02.setPagamento(pagto02);
		
		cli01.getPedidos().addAll(Arrays.asList(ped01, ped02));
		
		categoriaRepository.saveAll(Arrays.asList(cat01, cat02));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est01, est02));
		cidadeRepository.saveAll(Arrays.asList(c01, c02, c03));
		clienteRepository.saveAll(Arrays.asList(cli01));
		enderecoRepository.saveAll(Arrays.asList(e01, e02));
		pedidoRepository.saveAll(Arrays.asList(ped01, ped02));
		pagamentoRepository.saveAll(Arrays.asList(pagto01, pagto02));
	}
}
