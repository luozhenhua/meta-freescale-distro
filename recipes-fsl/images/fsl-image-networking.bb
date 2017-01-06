require recipes-core/images/core-image-minimal.bb

SUMMARY = "Minimal networking image used for evaluating the NXP SOCs"
DESCRIPTION = "The mininal networking image which includes some useful \
networking, benchmark and NXP specific packages. It is used for evaluating \
the NXP QorIQ SOCs."

LICENSE = "MIT"

IMAGE_INSTALL_append_qoriq = " \
    packagegroup-fsl-networking-core \
    packagegroup-fsl-networking-client \
    packagegroup-fsl-tools-benchmark \
"
