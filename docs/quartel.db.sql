-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22-Ago-2017 às 22:43
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quartel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acessorio`
--

CREATE TABLE `acessorio` (
  `id` int(10) UNSIGNED NOT NULL,
  `descricao` varchar(144) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `armamento`
--

CREATE TABLE `armamento` (
  `id` int(10) UNSIGNED NOT NULL,
  `serie` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `fabricante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cautela`
--

CREATE TABLE `cautela` (
  `id` int(11) NOT NULL,
  `id_reserva` int(10) UNSIGNED NOT NULL,
  `id_militar` int(10) UNSIGNED NOT NULL,
  `id_material` int(10) UNSIGNED NOT NULL,
  `data_retirada` datetime NOT NULL,
  `data_devolucao` datetime NOT NULL,
  `qtd` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `material`
--

CREATE TABLE `material` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_reserva` int(10) UNSIGNED NOT NULL,
  `id_usuario` int(10) UNSIGNED NOT NULL,
  `id_tipo_material` int(10) UNSIGNED NOT NULL,
  `qtd` int(10) UNSIGNED NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `militar`
--

CREATE TABLE `militar` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_reserva` int(10) UNSIGNED NOT NULL,
  `id_usuario` int(10) UNSIGNED DEFAULT NULL,
  `id_posto` int(10) UNSIGNED NOT NULL,
  `nome_guerra` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `militar_posto`
--

CREATE TABLE `militar_posto` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `militar_posto`
--

INSERT INTO `militar_posto` (`id`, `nome`) VALUES
(13, '1º Sargento'),
(9, '1º Tenente'),
(14, '2º Sargento'),
(10, '2º Tenente'),
(15, '3º Sargento'),
(11, 'Aspirante a Oficial'),
(17, 'Cabo'),
(8, 'Capitão'),
(5, 'Coronel'),
(4, 'General de Brigada'),
(3, 'General de Divisão'),
(2, 'General de Exército'),
(7, 'Major'),
(1, 'Marechal'),
(20, 'Soldado'),
(12, 'Subtenente'),
(18, 'Taifeiro de 1º Classe'),
(19, 'Taifeiro de 2º Classe'),
(16, 'Taifeiro-Mor'),
(6, 'Tenente-Coronel');

-- --------------------------------------------------------

--
-- Estrutura da tabela `municao`
--

CREATE TABLE `municao` (
  `id` int(10) UNSIGNED NOT NULL,
  `calibre` varchar(25) NOT NULL,
  `descricao` varchar(144) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE `reserva` (
  `id` int(10) UNSIGNED NOT NULL,
  `sigla` varchar(10) CHARACTER SET utf16 NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_material`
--

CREATE TABLE `tipo_material` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tipo_material`
--

INSERT INTO `tipo_material` (`id`, `nome`) VALUES
(3, 'acessório'),
(1, 'armamento'),
(2, 'munição');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(144) NOT NULL,
  `login` varchar(25) NOT NULL,
  `senha` varchar(80) NOT NULL,
  `email` varchar(144) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `login`, `senha`, `email`, `ativo`) VALUES
(1, 'root', 'root', 'FD26BC6A640CFA104CB319728FD171008635A7A9D3B090A5E17772208DDE8D81C98C1626A27162A9', 'root', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acessorio`
--
ALTER TABLE `acessorio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `armamento`
--
ALTER TABLE `armamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cautela`
--
ALTER TABLE `cautela`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cautela_reserva` (`id_reserva`),
  ADD KEY `fk_cautela_militar` (`id_militar`),
  ADD KEY `fk_cautela_material` (`id_material`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_material_usuario` (`id_usuario`),
  ADD KEY `fk_material_reserva` (`id_reserva`),
  ADD KEY `fk_material_tipo_material` (`id_tipo_material`);

--
-- Indexes for table `militar`
--
ALTER TABLE `militar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_militar_reserva` (`id_reserva`),
  ADD KEY `fk_militar_usuario` (`id_usuario`),
  ADD KEY `fk_militar_posto` (`id_posto`);

--
-- Indexes for table `militar_posto`
--
ALTER TABLE `militar_posto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ux_militar_posto` (`nome`) USING BTREE;

--
-- Indexes for table `municao`
--
ALTER TABLE `municao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ux_reserva_sigla` (`sigla`);

--
-- Indexes for table `tipo_material`
--
ALTER TABLE `tipo_material`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ux_tipo_material` (`nome`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ux_usuario_login` (`login`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cautela`
--
ALTER TABLE `cautela`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `militar`
--
ALTER TABLE `militar`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `militar_posto`
--
ALTER TABLE `militar_posto`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipo_material`
--
ALTER TABLE `tipo_material`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `acessorio`
--
ALTER TABLE `acessorio`
  ADD CONSTRAINT `fk_acessorio_material` FOREIGN KEY (`id`) REFERENCES `material` (`id`);

--
-- Limitadores para a tabela `armamento`
--
ALTER TABLE `armamento`
  ADD CONSTRAINT `fk_armamento_material` FOREIGN KEY (`id`) REFERENCES `material` (`id`);

--
-- Limitadores para a tabela `cautela`
--
ALTER TABLE `cautela`
  ADD CONSTRAINT `fk_cautela_material` FOREIGN KEY (`id_material`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `fk_cautela_militar` FOREIGN KEY (`id_militar`) REFERENCES `militar` (`id`),
  ADD CONSTRAINT `fk_cautela_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`);

--
-- Limitadores para a tabela `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `fk_material_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`),
  ADD CONSTRAINT `fk_material_tipo_material` FOREIGN KEY (`id_tipo_material`) REFERENCES `tipo_material` (`id`),
  ADD CONSTRAINT `fk_material_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `militar`
--
ALTER TABLE `militar`
  ADD CONSTRAINT `fk_militar_posto` FOREIGN KEY (`id_posto`) REFERENCES `militar_posto` (`id`),
  ADD CONSTRAINT `fk_militar_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`),
  ADD CONSTRAINT `fk_militar_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `municao`
--
ALTER TABLE `municao`
  ADD CONSTRAINT `fk_municao_material` FOREIGN KEY (`id`) REFERENCES `material` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
