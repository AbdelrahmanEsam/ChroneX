import co.touchlab.skie.configuration.SealedInterop

plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.kmp.shared)
}


skie {
    features {
        group {
            SealedInterop.Enabled(true)
            SealedInterop.ExportEntireHierarchy(true)
        }
    }
}