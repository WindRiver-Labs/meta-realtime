FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

KBRANCH_qemux86 = "standard/edf"
KBRANCH_fri2 = "standard/edf"

SRCREV_machine_qemux86 = "62d98f6b12f91cc7419b88dfa2e0abe077c94f9f"
SRCREV_machine_fri2 = "62d98f6b12f91cc7419b88dfa2e0abe077c94f9f"

KERNEL_FEATURES_append =" cfg/edf.scc"
