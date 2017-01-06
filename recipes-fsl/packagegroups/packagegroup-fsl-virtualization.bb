# Copyright (C) 2016 NXP Semiconductors
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Package group used by NXP Community to provide virtualization packages"
SUMMARY = "NXP Community Package group - virtualization, virtualization is \
the creation of a virtual -- rather than actual -- version of something, such \
as an operating system, it is an important feature of NXP QorIQ platforms, the \
major virtualization technique supported by QorIQ includes docker, qemu and lxc"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

DOCKER-PKGS = ""
DOCKER-PKGS_qoriq-arm = "docker docker-registry"
DOCKER-PKGS_qoriq-arm64 = "docker docker-registry"

RDEPENDS_${PN}_qoriq = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', \
    'libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
    lxc \
    qemu', \
    '', d)} \
    ${DOCKER-PKGS} \
" 
