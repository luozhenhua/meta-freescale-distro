# Copyright (C) 2016 NXP Semiconductors
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Package group used by NXP Community to provide networking packages"
SUMMARY = "NXP Community Package group - networking"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}-core ${PN}-core-extend \
    ${PN}-client ${PN}-server \
    ${PN}-extend"

QORIQ-PKGS = ""
# NOTE: Remove the conditional pkc-host inclusion and all traces of c29x_pkc
# DISTRO_FEATURE if pkc-host no longer requires customized cryptodev patches
QORIQ-PKGS_qoriq = "asf merge-files udev-rules-qoriq \
    ${@bb.utils.contains('DISTRO_FEATURES', 'c29x_pkc', 'pkc-host', '', d)} \
"

QORIQ-PKGS_append_qoriq-ppc = " \
    apptrk \
    dpa-offload \
    eth-config \
    usdpaa-apps \
    hypervisor-partman \
"
QORIQ-PKGS_append_fsl-lsch3 = " restool"
QORIQ-PKGS_append_e500v2 = "apptrk testfloat"
QORIQ-PKGS_append_e6500-64b = " kernel-module-ceetm"

# e6500 only support 64bit hypervisor
QORIQ-PKGS_remove_e6500 = "hypervisor-partman"
QORIQ-PKGS_append_e6500 = " lib64-hypervisor-partman"

QORIQ-PKGS_append_c293pcie = " skmm-ep"
QORIQ-PKGS_append_ls1043ardb = " eth-config usdpaa usdpaa-apps dpa-offload"
QORIQ-PKGS_append_ls1046rrdb = " eth-config usdpaa usdpaa-apps dpa-offload"
QORIQ-PKGS_append_p1023rdb = " fmc eth-config"
QORIQ-PKGS_append_b4860qds = "\
    ipc-ust \
    kernel-module-ipc-multi \
    kernel-module-ipc-single \
"
QORIQ-PKGS_append_b4420qds = "\
    ipc-ust \
    kernel-module-ipc-multi \
    kernel-module-ipc-single \
"
QORIQ-PKGS__append_p4080ds = "\
    skmm-ep \
    skmm-host \
"
QORIQ-PKGS_append_t4240qds = "\
    skmm-ep \
    skmm-host \
"
QORIQ-PKGS_append_t1040 = " \
    ceetm \
    kernel-module-ar \
    kernel-module-uio-seville \
"
QORIQ-PKGS_append_t1042 = " \
    ceetm \
    kernel-module-ar \
"

RDEPENDS_${PN}-core_qoriq = " \
    coreutils \
    elfutils \
    e2fsprogs \
    e2fsprogs-badblocks \
    e2fsprogs-e2fsck \
    e2fsprogs-tune2fs  \
    file \
    i2c-tools \
    kmod \
    libhugetlbfs \
    lmsensors-sensors \
    memtester \
    minicom \
    pkgconfig \
    python-subprocess \
    python-datetime \
    python-json \
    procps \
    psmisc \
    sysfsutils \
    sysklogd \
    sysstat \
    ${QORIQ-PKGS} \
"

RDEPENDS_${PN}-core-extend_qoriq = " \
    bc \
    chkconfig \
    cronie \
    db \
    debianutils \
    dtc \
    lsof \
    man \
    man-pages \
    oprofile \
    parted \
    perf \
    rng-tools \
    rt-tests \
    sqlite3 \
    strongswan \
    texinfo \
    u-boot-mkimage \
    unzip \
    usbutils \
    watchdog \
    which \
    xz  \
    zip \
"

RDEPENDS_${PN}-client_qoriq = " \
    bridge-utils \
    ethtool \
    iproute2 \
    iproute2-tc \
    iptables \
    iputils \
    inetutils \
    inetutils-ftp \
    inetutils-hostname \
    inetutils-ifconfig \
    inetutils-logger \
    inetutils-ping \
    inetutils-ping6 \
    inetutils-rsh \
    inetutils-syslogd \
    inetutils-telnet \
    inetutils-tftp \
    inetutils-traceroute \
    ipsec-tools \
    ipsec-demo \
    net-tools \
    tcpdump \
"

RDEPENDS_${PN}-server_qoriq = " \
    inetutils-inetd \
    inetutils-ftpd \
    inetutils-rshd \
    inetutils-tftpd \
    inetutils-telnetd \
"

RDEPENDS_${PN}-client_append_qoriq = "\
    packagegroup-fsl-networking-server \
"

RDEPENDS_${PN}-extend_qoriq = " \
    bind \
    curl \
    dhcp-client \
    libnfnetlink \
    linuxptp \
    ntpdate \
    ppp \
    ppp-dialin \
    ptpd \
    resolvconf \
    rp-pppoe \
    samba \
    wget \
    xinetd \
"
